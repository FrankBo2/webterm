/**
 * This file is part of WebTerm.
 *
 * WebTerm is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebTerm is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with WebTerm. If not, see <http://www.gnu.org/licenses/>.
 *
 * (C) COPYRIGHT 2008 - Charles FENDT
 */
package org.webterm.connections;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.webterm.core.screen.CharacterColor;
import org.webterm.core.screen.CharacterDescription;
import org.webterm.core.screen.FieldProperties;
import org.webterm.core.screen.ScreenDescription;
import org.webterm.term.AbstractTermDescription;

/**
 * Thread for a server connection management.
 * 
 * @author charles
 */
public class ConnectionHandler {

	/** Logger */
	private static final Logger LOG = Logger.getLogger(ConnectionHandler.class);

	/** Screen description */
	private transient final ScreenDescription screenDesc;
	
	private transient final AbstractTermDescription term;
	
	/** Current horizontal position */
	transient private int x = 0;
	
	/** Current vertical position */
	transient private int y = 0;
	
	/** Current color */
	transient private CharacterColor col;
	
	/** client properties*/
	private LinkProperties clientProperties = new LinkProperties();
	
	/** server properties*/
	private LinkProperties serverProperties = new LinkProperties();
	
	/** "Write To Display" boolean */
	private boolean wtd = false;
	private boolean moveToSend = false;
	private int textSend = 0;
	private boolean reading = false;
	
	private transient final InputStream in;
	private transient final OutputStream out;
	
	private transient final Map<String, String> envVar = new HashMap<String, String>();
	private transient final Map<String, String> usrVar = new HashMap<String, String>();
	
	/**
	 * Constructor
	 * 
	 * @param term Terminal description
	 * @param socket Socket
	 */
	public ConnectionHandler (final AbstractTermDescription term, final Socket socket) throws IOException {
		this.term = term;
		this.screenDesc = new ScreenDescription(term.getHeight(), term.getWidth());
			
		this.in = new BufferedInputStream(socket.getInputStream());
		this.out = new BufferedOutputStream(socket.getOutputStream());
	}
	
	/**
	 * Method to clear the screen
	 */
	public void clearScreen() {
		x = 0;
		y = 0;
		screenDesc.initScreen();
	}
	
	/**
	 * Dump screen to HTML
	 * 
	 * @return HTML code for the screen
	 */
	public String dumpScreen() {

		final StringBuilder screen = new StringBuilder();
	    screen.append("\r\n<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" bgcolor=\"#000000\">\r\n");
	    screen.append("<tr>\r\n\t<td><font color=\"#000000\">|</font></td>");
	    for (int i = 0; i < screenDesc.width; i++) {
	        screen.append("<td><font color=\"#000000\">_</font></td>");
	    }
	    screen.append("<td><font color=\"#000000\">|</font></td>\r\n</tr>");
	   
	    for (int j = 0; j < screenDesc.height; j++) {
	        screen.append("<tr>\r\n\t<td><font color=\"#000000\">|</font></td>");
		    for (int i = 0; i < screenDesc.width; i++) {
		    	final CharacterDescription charDesc = screenDesc.get(i, j);
	            screen.append("<td gbcolor=\"");
	            screen.append(charDesc.color.colorBackground.htmlCode);
	    	    screen.append("\"><font color=\"");
	            screen.append(charDesc.color.colorFont.htmlCode);
	            screen.append("\">");
	            screen.append(charDesc.character);
	            screen.append("</font></td>");
	        }
	        screen.append("<td><font color=\"#000000\">|</font></td>\r\n</tr>");
	    }
	    screen.append("\r\n</table>\r\n\r\n");
	    screen.append("\t</body>\r\n</html>\r\n");
	    
	    return screen.toString();
	}

	private void treatData(final char serverCh, final StringBuilder log) {
	    final CharacterDescription cd = screenDesc.get(x, y);
		cd.color = col;

	    final char ch = term.decode(serverCh);
	    
	    if ((ch < 32) || (ch > 240)) {
	    	cd.character = ' ';
	        log.append("...");
	    } else {
	        cd.character = ch;
	        log.append('\'');
	        log.append(ch);
	        log.append('\'');
	    }
	    log.append("[" + String.format("%2X", serverCh) + "]\t");
	    
	    ++this.x;
	    if (this.x >= this.screenDesc.width) {
	    	this.x = 0;
	    	++this.y;
	    }
	    if (this.y >= this.screenDesc.height) {
	    	this.y = 0;
	    }
	}

	private void answerIAC(final char query, final StringBuilder log) throws IOException {
	    log.append("<= IAC ");
	    
	    switch (query) {
	    
	        case (239) :
	            log.append("EOR\n");
	            reading = false;
	            break;
	            
	        case (240) :
	            log.append("SE\n");
	            log.append("ERROR : unexpected command\n");
	            break;
	        
	        case (241) :
	            log.append("NOP\n");
	            break;
	            
	        case (242) :
	            log.append("Data Mark ");
	            break;
	            
	        case (243) :
	            log.append("Break");
	            break;
	            
	        case (244) :
	            log.append("IP");
	            break;
	            
	        case (245) :
	            log.append("AO");
	            break;
	            
	        case (246) :
	            log.append("AYT");
	            break;
	        
	        case (247) :
	            log.append("EC");
	            break;
	        
	        case (248) :
	            log.append("EL") ;
	            break;
	            
	        case (249) :
	            log.append("GA");
	            break;
	            
	        case (250) :
	            log.append("SB ");
	            
	        	char what = (char) in.read();
	            switch (what) {
	            
	                // case of TERMINAL-TYPE
	                case (24) :
	                {
	                    log.append("TERMINAL-TYPE ");
	                    final String type = "TERMINAL-TYPE";
	                    if (in.read() != 1) log.append("\nERROR : waiting for SEND command (01)\n");
	                    log.append("SEND ");
	                    if (in.read() != 255) log.append("\nERROR : waiting for IAC command (255)\n");
	                    log.append("IAC ");
	                    if (in.read() != 240) log.append("\nERROR : waiting for SE command (240)\n");
	                    log.append("SE\n");
	                    log.append("\t=> IAC SB TERMINAL-TYPE IS "+ term.getPhysicalTermType()+" IAC SE\n");
	                    String mess = Character.toString((char) 255)+Character.toString((char) 250)+Character.toString((char) 24)+Character.toString((char) 0)+term.getPhysicalTermType()+Character.toString((char) 255)+Character.toString((char) 240);
	                    sendMessage(type, mess, log);
	                    closeMessageQueue(type);
	                }
	                    break;
	                
	                // case of NEW-ENVIRON
	                case (39) :
	                
	                    log.append("NEW-ENVIRON ");
	                    final String type = "NEW-ENVIRON";
	                    
	                    if (in.read() != 1) {
	                    	log.append("\nERROR : waiting for SEND command (01)\n");
	                    }
	                    
	                    final StringBuilder out_string = new StringBuilder("\t=> IAC SB NEW-ENVIRON IS ");
	                    String out = Character.toString((char) 255) + Character.toString((char) 250) + Character.toString((char) 39) + Character.toString((char) 0);
	                    
	                    char var_type = (char) in.read();
	                    
	                    while (var_type != 255) {
	                        char next = (char) in.read();
	                        switch (var_type) {
	                            case (0) :
	                                // variable
	                                if ((next > 3) && (next != 255)) {
	                                    // send just one variable
	                                    String var_name = "";
	                                    String var_name_hex = "";

	                                    while ((next > 3) && (next != 255)) {
	                
	                                        var_name += Character.toString((char) next);
	                                        var_name_hex += String.format("%2X", next);
	                                        next = (char) in.read();
	                    
	                                    }
	                     
	                                    log.append("VAR "+var_name+"["+var_name_hex+"] ");
	       
	                                    if (envVar.containsKey(var_name)) {

	                                        out_string.append("VAR "+var_name+" VALUE ");
	                                        out += Character.toString((char) 0)+var_name+Character.toString((char) 1);
	                                        out_string.append(envVar.get(var_name) + " ");
	                                        out += envVar.get(var_name);
	                                    }
	                                } else {
	                                    // send all uservar
	                                    log.append("VAR ");
	                                    for (final String name : envVar.keySet()) {
	                                    	final String value = envVar.get(name);
	                                         out_string.append("VAR "+name+" VALUE "+value+" ");
	                                        out += Character.toString((char) 0)+name+Character.toString((char) 1)+value;
	                                    }
	                                }
	                                break;
	                            case (3) :
	                                // uservar
	                                if ((next > 3) && (next != 255)) {
	                                    // send juste one uservar
	                                    String uservar_name = "";
	                                    String uservar_name_hex = "";
	                                    while ((next > 3) && (next != 255)) {
	                                        uservar_name += Character.toString((char) next);
	                                        uservar_name_hex += String.format("%2X", next);
	                                        next = (char) in.read();
	                                    }
	                                    log.append("USERVAR "+uservar_name+"["+uservar_name_hex+"] ");
	                                    if (usrVar.containsKey(uservar_name)) {
	                                        out_string.append("USERVAR "+uservar_name+" VALUE ");
	                                        out += Character.toString((char) 3)+uservar_name+Character.toString((char) 1);
	                                        out_string.append(usrVar.get(uservar_name) + " ");
	                                        out += usrVar.get(uservar_name);
	                                    }

	                                } else {
	                                    // send all uservar
	                                    log.append("USERVAR ");
	                                    for (final String name : usrVar.keySet()) {
	                                    	final String value = usrVar.get(name);
	                                        out_string.append("USERVAR "+name+" VALUE "+value+" ");
	                                        out += Character.toString((char) 3)+name+Character.toString((char) 1)+value;
	                                    }
	                                }
	                                break;
	                            default :
	                                log.append("\nERROR : unknown type " + var_type + "\n");
	                        }
	                        var_type = next;
	                    }
	                    
	                    log.append("IAC ");
	                    if (in.read() != 240) log.append("\nERROR : waiting for SE command (240)\n");
	                    log.append("SE\n");
	                    
	                    out_string.append("IAC SE\n");
	                    out += Character.toString((char) 255)+Character.toString((char) 240);
	                    
	                    sendMessage(type, out, out_string);

	                    closeMessageQueue(type);
	                    break;

	                default :
	                    log.append("ERROR : unknown code " + what + "\n");
	            }
	             
	            break;
	            
	        case (251) :
	            log.append("WILL ");
	            what = (char) in.read();
	            switch (what) {
	                  
	                case (0) :
	                    // BINARY
	                    log.append("BINARY\n");
	                    String type = "BINARY";
	                    serverProperties.setBinary(true);
	                    log.append("\t=> IAC WILL BINARY\n");
	                    log.append("\t=> IAC DO BINARY\n");
	                    String mess =  Character.toString((char) 255)+Character.toString((char) 251)+Character.toString((char) 0);
	                    mess += Character.toString((char) 255)+Character.toString((char) 253)+Character.toString((char) 0);
	                    sendMessage(type, mess, log);
	                    closeMessageQueue(type);
	                    break;
	                    
	                case (25) :
	                    // END-OF-RECORD
	                    log.append("END-OF-RECORD\n");
	                    type = "END-OF-RECORD";
	                    serverProperties.setEndOfRecord(true);
	                    log.append("\t=> IAC WILL END-OF-RECORD\n");
	                    log.append("\t=> IAC DO END-OF-RECORD\n");
	                    mess =  Character.toString((char) 255)+Character.toString((char) 251)+Character.toString((char) 25);
	                    mess += Character.toString((char) 255)+Character.toString((char) 253)+Character.toString((char) 25);
	                    sendMessage(type, mess, log);
	                    closeMessageQueue(type);
	                    break;

	                default :
	                     log.append("\nERROR : unknown type "+what+"\n");
	            }   
	            break;
	            
	        case (252) :
	            log.append("WON'T ");
	            break;
	            
	        case (253) :
	            log.append("DO ");
	            
	            what = (char) in.read();
	            switch (what) {

	                // case of END-OF-RECORD
	                case (0) :
	                    log.append("BINARY\n");
	                    clientProperties.setBinary(true);
	                    break;
	            
	                // case of TERMINAL-TYPE
	                case (24) :

	                    log.append("TERMINAL-TYPE\n");

	                    String type = "TERMINAL-TYPE";
	                    log.append("\t=> IAC WILL TERMINAL-TYPE\n");
	                    String mess = Character.toString((char) 255) + Character.toString((char) 251) + Character.toString((char) 24);
	                    sendMessage(type, mess, log);
	                    break;                     
	                // case of END-OF-RECORD
	                case (25) :
	                    log.append("END-OF-RECORD\n");
	                    clientProperties.setEndOfRecord(true);
	                    break;
	                
	                // case of NEW-ENVIRON
	                case (39) :
	                    log.append("NEW-ENVIRON\n");
	                    type = "NEW-ENVIRON";
	                    log.append("\t=> IAC WILL NEW-ENVIRON\n");
	                    mess = Character.toString((char) 255) + Character.toString((char) 251) + Character.toString((char) 39);
	                    sendMessage(type, mess, log);
	                    break;
	                default :
	                    log.append("\nERROR : unknown code " + what + "\n");
	            }
	            break;
	            
	        case (254) :
	            log.append("DON'T");
	            break;
	            
	        default :
	            log.append("\nERROR : unknown code " + Character.toString((char) query) + "\n");
	    }
	}

	/**
	 * Method to read from the server. The display screen is modified according to readed data.
	 * 
	 * @param log Log stringBuilder.
	 */
	private void read(final StringBuilder log) {
	    boolean nego = true;
	    this.reading = true;
	    while (this.reading) {

	        char ch = (char) in.read();

	        if ((ch != 255) && (nego == true)) {
	            nego = false;
	            int len = (ch * 256) + in.read();
	            log.append("Length = " + len + "\n");

	            for (int i = 0; i < 7; ++i) {
	                log.append(String.format("%2X ", in.read()));
	            }    
	            char opcode = (char) in.read();
	            log.append("\nopCode = "+opcode+"\n");
	            ch = (char) in.read();
	        }


	        
	        switch (ch) {
	        
	            case (1) :
	                log.append("<= SOH ");
	                int len = in.read();
	                log.append(String.format("%2X", len));
	                if ((len > 7) || (len == 0)) len = 4;
	                if (len > 0) log.append(String.format("%2X", in.read()));
	                if (len > 1) log.append(String.format("%2X", in.read()));
	                if (len > 2) log.append(String.format("%2X", in.read()));
	                final char error_line = (char) in.read();
	                log.append(String.format("%2X", error_line));
	                for (int i = 2; i >= 0; i--) {
	                    char flag = 255;
	                    if (len > (6 - i)) {
	                        flag = (char) in.read();
	                        log.append(String.format("%2X", flag));
	                    }
	                    for (int j = 7; j >=0; j--) {
	                        tn5250["screen"]["submit_key"]["F"+(1+j+(8*i))] = (((flag >> j) & 1) == 1);
	                    }
	                }
	                log.append("\n");
	                break;

	            case (2) :
	                log.append("<= REPEAT ");
	                int to_y = in.read();
	                int to_x = in.read();
	                char todo = (char) in.read();
	                if (todo > 32) {
	                    todo = term.decode(todo);
	                }
	                log.append("toY=\""+to_y+"\" toX=\""+to_x+"\" todo=\""+todo+"\"\n");
					if (textSend == 1) {
						textSend = 0;
					}
	                break;
	                            case (4) :
	                log.append("<= ESC ");
	                char what = (char) in.read();
	                switch (what) {

	                    case (17) :
	                        log.append("WRITE TO DISPLAY\n");
	                        wtd = true;
	                        {
	                        	final char control_char_0 = (char) in.read(); //NOPMD
	                        	final char control_char_1 =(char)  in.read(); //NOPMD
	                        }
	                        break;
	                    
	                    case (64) :
	                        log.append("CLEAR UNIT\n");
							moveToSend = false;
							textSend = 0;
							clearScreen();
	                        break;

	                    case (82) :
	                        log.append("READ MTD\n");
	                        {
	                        	final char control_char_0 = (char) in.read(); //NOPMD
	                        	final char control_char_1 =(char)  in.read(); //NOPMD
	                        }
	                        break;
	                    
	                    case (130) :
	                        log.append("READ MTD\n");
	                        {
	                        	final char control_char_0 = (char) in.read(); //NOPMD
	                        	final char control_char_1 =(char)  in.read(); //NOPMD
	                        }
	                        break;
	                    
	                    case (243) :
	                        log.append("QUERY (WSF)\n");
	                        len = (in.read() * 256) + in.read() - 2;
	                        log.append("len = "+len+"\n");
	                        for (int i=0; i<len; i++) {
	                            log.append(String.format("%2X", in.read()));
	                        }
	                        log.append("\n");
	                        answerToWSF();
	                        break;
	                        
	                    default :
	                        log.append("??? ["+what+"]\n");
	                }
	                break;
	                
	            case (17) :
	                y = in.read();
	                x = in.read();
	                log.append("<= MOVE TO ["+y+";"+x+"] '"+moveToSend+"' \n");
					if (moveToSend && (textSend == 1)) {
						textSend = 0;
					}
					moveToSend = true;
	                break;
	                
	            case (29) :
	                log.append("<= Start of Field Order ");
	                what = (char) in.read();
	                int num = -1;
	                if ((what & 0x40) != 0) {
	                	final FieldProperties field = new FieldProperties();
	                    log.append("FFW ");
	                    field.setActive(true);
	                    field.setFfw0(what);
	                    field.setFfw1((char) in.read());
	                    
	                    what = (char) in.read();
	                    if ((what & 0x80) != 0) {
	                        log.append("FCW ");
		                    field.setFcw0(what);
		                    field.setFcw1((char) in.read());
	                        what = (char) in.read();
	                    }

	                    this.col = CharacterColor.findColor(what);
	                    len = (in.read() * 256) + in.read();
	                    field.setColor(col);
	                    field.setLength(len);
	                    
	                    this.screenDesc.getFields().add(field);
						if (textSend == 1) {
							textSend = 0;
						}
	                } else {
	                	this.col = CharacterColor.findColor((char) in.read());
	                    len = (in.read() * 256) + in.read();
						if (textSend == 1) {
							textSend = 0;
						}
	                }
	                break;
	                
	            case (255) :
	                char esc_ch = (char) in.read();
	                if (esc_ch == 255) {
	                    treatData(esc_ch, log);
	                } else {
	                    answerIAC(esc_ch, log);
	                }
	                break;
	                
	            default :
	                if ((ch >= 0x20) && (ch<40)) {
	                	this.col = CharacterColor.findColor(ch);
	                    log.append("<= COLOR "+this.col.colorFont.htmlCode+"\n");
						if (textSend == 1) {
							textSend = 0;
						}
	                } else {
	                    treatData(ch, log);
	                }
	        }

	    }
		if (moveToSend) {
			moveToSend = false;
		}

	}

	/**
	 * Method to read the screen from the socket. 
	 */
	public void readScreen() {
		final StringBuilder log = new StringBuilder();
	    this.wtd = false;
	    while (!wtd) {
	    	this.moveToSend = false;
	    	this.textSend = 0;
	        read(log);
	    }
	    LOG.info(log.toString());
	}

	private void sendMessage(final String type, final String mess, final StringBuilder log) {
	    if (!isset(tn5250["connexion"]["queue"]["open"][type])) {
	        num = tn5250["connexion"]["queue"]["next"];
	        tn5250["connexion"]["queue"]["open"][type] = num;
	        tn5250["connexion"]["queue"]["next"]++;
	        tn5250["connexion"]["queue"]["length"]++;
	        tn5250["connexion"]["queue"]["queue"][num] = array();
	        tn5250["connexion"]["queue"]["queue"][num]["message"] = "";
	        tn5250["connexion"]["queue"]["queue"][num]["log"] = "";
	        tn5250["connexion"]["queue"]["queue"][num]["type"] = type;
	        tn5250["connexion"]["queue"]["queue"][num]["status"] = "open";
	    }
	    num = tn5250["connexion"]["queue"]["open"][type];
	    if (num == tn5250["connexion"]["queue"]["current"]) {
	    	for (char ch : mess.toCharArray()) {
	    		out.write(ch);
	    	}
	    	out.flush();
	        //echo log;
	    }
	    tn5250["connexion"]["queue"]["queue"][num]["message"] += mess;
	    tn5250["connexion"]["queue"]["queue"][num]["log"] += log;
	}

	private boolean closeMessageQueue(final String type) {
	    
	    if (!isset(tn5250["connexion"]["queue"]["open"][type])) {
	        return false;
	    }
	    num = tn5250["connexion"]["queue"]["open"][type];
	    unset(tn5250["connexion"]["queue"]["open"][type]);
	    tn5250["connexion"]["queue"]["queue"][num]["status"] = "closed";

	    if (num == tn5250["connexion"]["queue"]["current"]) {
	         loop = false;
	        do {
	            tn5250["connexion"]["queue"]["current"]++;
	            tn5250["connexion"]["queue"]["length"]--;
	            if (tn5250["connexion"]["queue"]["length"] > 0) {
	                num++;
	                fwrite(fp, tn5250["connexion"]["queue"]["queue"][num]["message"]);
	                fflush(fp);
	                //echo tn5250["connexion"]["queue"]["queue"][num]["log"];
	                loop = (tn5250["connexion"]["queue"]["queue"][num]["status"] == "closed");
	            } else {
	                loop = false;
	            }
	        } while (loop);
	    }
	    return true;
	}

	private void sendToHost(final String text, final String opcode) {
	    
	    int len = text.length() + 10;
	    String length = Character.toString((char) ((len >> 8) & 0xFF))+Character.toString((char) (len & 0xFF));

	    fwrite(fp, length+
	        Character.toString((char) 0x12)+Character.toString((char) 0xA0)+Character.toString((char) 0)+Character.toString((char) 0)+Character.toString((char) 04)+Character.toString((char) 0)+Character.toString((char) 0)+Character.toString((char) tn5250["opCode"][opcode])+
	        text+
	        Character.toString((char) 0xFF)+Character.toString((char) 0xEF)
	    );
	    fflush(fp);

	    mesg = length+
	        Character.toString((char) 0x12)+Character.toString((char) 0xA0)+Character.toString((char) 0)+Character.toString((char) 0)+Character.toString((char) 04)+Character.toString((char) 0)+Character.toString((char) 0)+Character.toString((char) tn5250["opCode"][opcode])+
	        text+
	        Character.toString((char) 0xFF)+Character.toString((char) 0xEF);

	    log.append("\n    =>\t");
	    for (int i = 0; i < mesg.length; ++i) {
	    	log.append("["+Integer.toString(mesg.charAt(i), 16)+"]\t");
	    }
	    log.append("\n");

	}


	private void answerToWSF() {

	    String answer = 
	        Character.toString((char) 0x00)+		/* Cursor Row/Column (set to zero) */
	        Character.toString((char) 0x00)+

	        Character.toString((char) 0x88)+		/* Inbound Write Structured Field Aid */

	        Character.toString((char) 0x00)+		/* Length of Query Reply */
	        Character.toString((char) 0x3A)+

	        Character.toString((char) 0xD9)+		/* Command class */

	        Character.toString((char) 0x70)+		/* Command type - Query */

	        Character.toString((char) 0x80)+		/* Flag byte */

	        Character.toString((char) 0x06)+		/* Controller hardware class */
	        Character.toString((char) 0x00)+

	        Character.toString((char) 0x01)+		/* Controller code level (Version 1 Release 1.0 */
	        Character.toString((char) 0x01)+
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+		/* Reserved (set to zero) */
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+

	        Character.toString((char) 0x01);		/* 5250 Display or 5250 emulation */

	    final String dev_type  = term.getPhysicalTermType().substring(4, 8);
	    String dev_model = Character.toString((char) 0) + term.getPhysicalTermType().substring(9);

	    if (dev_model.length() == 2) {
	    	dev_model = Character.toString((char) 0)+dev_model;
	    }

	    answer += term.encode(dev_type+dev_model);

	    answer +=

	        Character.toString((char) 0x02)+		/* Keyboard ID:
					   X'02' = Standard Keyboard
					   X'82' = G Keyboard */

	        Character.toString((char) 0x00)+		/* Extended keyboard ID */
	        Character.toString((char) 0x00)+		/* Reserved */

	        Character.toString((char) 0x00)+		/* Display serial number */
	        Character.toString((char) 0x61)+
	        Character.toString((char) 0x50)+
	        Character.toString((char) 0x00)+

	        Character.toString((char) 0xff)+		/* Maximum number of input fields (65535) */
	        Character.toString((char) 0xff)+

	        Character.toString((char) 0x00)+		/* Reserved (set to zero) */
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+

	        Character.toString((char) 0x23)+		/* Controller/Display Capability */
	        Character.toString((char) 0x31)+
	        Character.toString((char) 0x00)+		/* Reserved */
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+

	        Character.toString((char) 0x00)+		/* Reserved (set to zero) */

	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00)+
	        Character.toString((char) 0x00);

	    sendToHost(answer, "NoOperation");
	}

}
