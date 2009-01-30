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
import org.webterm.core.ConstString;
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

	/** char for opcode map */
	private static final Map<String, Character> opCodeMap = new HashMap<String, Character>();
	
	static {
		opCodeMap.put("NoOperation", Character.valueOf((char) 0x00)); //$NON-NLS-1$
		opCodeMap.put("InviteOperation", Character.valueOf((char) 0x01)); //$NON-NLS-1$
		opCodeMap.put("OutputOnly", Character.valueOf((char) 0x02)); //$NON-NLS-1$
		opCodeMap.put("PutGetOperation", Character.valueOf((char) 0x03)); //$NON-NLS-1$
		opCodeMap.put("SaveScreenOperation", Character.valueOf((char) 0x04)); //$NON-NLS-1$
	    opCodeMap.put("RestoreScreenOperation", Character.valueOf((char) 0x05)); //$NON-NLS-1$
	    opCodeMap.put("ReadImmediateOperation", Character.valueOf((char) 0x06)); //$NON-NLS-1$
	    opCodeMap.put("ReadScreenOperation", Character.valueOf((char) 0x08)); //$NON-NLS-1$
	    opCodeMap.put("CancelInviteOperation", Character.valueOf((char) 0x0A)); //$NON-NLS-1$
	    opCodeMap.put("TurnOnMessageLight", Character.valueOf((char) 0x0B)); //$NON-NLS-1$
	    opCodeMap.put("TurnOffMessageLight", Character.valueOf((char) 0x0C)); //$NON-NLS-1$
	}
	/** Screen description */
	private transient final ScreenDescription screenDesc;
	
	/** Terminal description */
	private transient final AbstractTermDescription term;
	
	/** Current horizontal position */
	transient private int screenX = 0;
	
	/** Current vertical position */
	transient private int screenY = 0;
	
	/** Current color */
	transient private CharacterColor col;
	
	/** client properties*/
	transient private final LinkProperties clientProperties = new LinkProperties();
	
	/** server properties*/
	transient private final LinkProperties serverProperties = new LinkProperties();
	
	/** "Write To Display" boolean */
	transient private boolean wtd = false;
	/** moveToSend */
	transient private boolean moveToSend = false;
	/** textSend */
	transient private int textSend = 0;
	/** reading */
	transient private boolean reading = false;
	
	/** server input stream */
	private transient final InputStream input;
	/** server output stream */
	private transient final OutputStream output;
	
	/** environment variables */
	private transient final Map<String, String> envVar = new HashMap<String, String>();
	/** users variables */
	private transient final Map<String, String> usrVar = new HashMap<String, String>();
	
	/**
	 * Constructor
	 * 
	 * @param term Terminal description
	 * @param socket Socket
	 * @throws IOException I/O error
	 */
	public ConnectionHandler (final AbstractTermDescription term, final Socket socket) throws IOException {
		this.term = term;
		this.screenDesc = new ScreenDescription(term.getHeight(), term.getWidth());
			
		this.input = new BufferedInputStream(socket.getInputStream());
		this.output = new BufferedOutputStream(socket.getOutputStream());
	}
	
	/**
	 * Character format method
	 * 
	 * @param character character to format
	 * @return String with the hexadecimal code of the character;
	 */
	private String formatChar(final int character) {
		return String.format("%2X", Integer.valueOf(character)); //$NON-NLS-1$
	}
	/**
	 * Method to clear the screen
	 */
	public void clearScreen() {
		this.screenX = 0;
		this.screenY = 0;
		this.screenDesc.initScreen();
	}
	
	/**
	 * Dump screen to HTML
	 * 
	 * @return HTML code for the screen
	 */
	public String dumpScreen() {

		final StringBuilder screen = new StringBuilder();
	    screen.append("\r\n<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" bgcolor=\"#000000\">\r\n"); //$NON-NLS-1$
	    screen.append("<tr>\r\n\t<td><font color=\"#000000\">|</font></td>"); //$NON-NLS-1$
	    for (int i = 0; i < this.screenDesc.width; i++) {
	        screen.append("<td><font color=\"#000000\">_</font></td>"); //$NON-NLS-1$
	    }
	    screen.append("<td><font color=\"#000000\">|</font></td>\r\n</tr>"); //$NON-NLS-1$
	   
	    for (int j = 0; j < this.screenDesc.height; j++) {
	        screen.append("<tr>\r\n\t<td><font color=\"#000000\">|</font></td>"); //$NON-NLS-1$
		    for (int i = 0; i < this.screenDesc.width; i++) {
		    	final CharacterDescription charDesc = this.screenDesc.get(i, j);
	            screen.append("<td gbcolor=\""); //$NON-NLS-1$
	            screen.append(charDesc.color.colorBackground.htmlCode);
	    	    screen.append("\"><font color=\""); //$NON-NLS-1$
	            screen.append(charDesc.color.colorFont.htmlCode);
	            screen.append("\">"); //$NON-NLS-1$
	            screen.append(charDesc.character);
	            screen.append("</font></td>"); //$NON-NLS-1$
	        }
	        screen.append("<td><font color=\"#000000\">|</font></td>\r\n</tr>"); //$NON-NLS-1$
	    }
	    screen.append("\r\n</table>\r\n\r\n"); //$NON-NLS-1$
	    screen.append("\t</body>\r\n</html>\r\n"); //$NON-NLS-1$
	    
	    return screen.toString();
	}

	/**
	 * Treatment method
	 * 
	 * @param serverCh Char from server side
	 * @param log Logger
	 */
	private void treatData(final char serverCh, final StringBuilder log) {
	    final CharacterDescription cd = this.screenDesc.get(this.screenX, this.screenY);
		cd.color = this.col;

	    final char ch = this.term.decode(serverCh);
	    
	    if ((ch < 32) || (ch > 240)) {
	    	cd.character = ' ';
	        log.append("..."); //$NON-NLS-1$
	    } else {
	        cd.character = ch;
	        log.append('\'');
	        log.append(ch);
	        log.append('\'');
	    }
	    log.append("[" + formatChar(serverCh) + "]\t"); //$NON-NLS-1$ //$NON-NLS-2$
	    
	    ++this.screenX;
	    if (this.screenX >= this.screenDesc.width) {
	    	this.screenX = 0;
	    	++this.screenY;
	    }
	    if (this.screenY >= this.screenDesc.height) {
	    	this.screenY = 0;
	    }
	}

	/**
	 * response method
	 * 
	 * @param query Query char
	 * @param log Logger
	 * @throws IOException I/O error
	 */
	private void answerIAC(final char query, final StringBuilder log) throws IOException {
	    log.append("<= IAC "); //$NON-NLS-1$
	    
	    switch (query) {
	    
	        case (239) :
	            log.append("EOR\n"); //$NON-NLS-1$
	        	this.reading = false;
	            break;
	            
	        case (240) :
	            log.append("SE\n"); //$NON-NLS-1$
	            log.append("ERROR : unexpected command\n"); //$NON-NLS-1$
	            break;
	        
	        case (241) :
	            log.append("NOP\n"); //$NON-NLS-1$
	            break;
	            
	        case (242) :
	            log.append("Data Mark "); //$NON-NLS-1$
	            break;
	            
	        case (243) :
	            log.append("Break"); //$NON-NLS-1$
	            break;
	            
	        case (244) :
	            log.append("IP"); //$NON-NLS-1$
	            break;
	            
	        case (245) :
	            log.append("AO"); //$NON-NLS-1$
	            break;
	            
	        case (246) :
	            log.append("AYT"); //$NON-NLS-1$
	            break;
	        
	        case (247) :
	            log.append("EC"); //$NON-NLS-1$
	            break;
	        
	        case (248) :
	            log.append("EL") ; //$NON-NLS-1$
	            break;
	            
	        case (249) :
	            log.append("GA"); //$NON-NLS-1$
	            break;
	            
	        case (250) :
	            log.append("SB "); //$NON-NLS-1$
	            
	        	char what = (char) this.input.read();
	            switch (what) {
	            
	                // case of TERMINAL-TYPE
	                case (24) :
	                {
	                    log.append("TERMINAL-TYPE "); //$NON-NLS-1$
	                    final String type = "TERMINAL-TYPE"; //$NON-NLS-1$
	                    if (this.input.read() != 1) {
	                    	log.append("\nERROR : waiting for SEND command (01)\n"); //$NON-NLS-1$
	                    }
	                    log.append("SEND "); //$NON-NLS-1$
	                    if (this.input.read() != 255) {
	                    	log.append("\nERROR : waiting for IAC command (255)\n"); //$NON-NLS-1$
	                    }
	                    log.append("IAC "); //$NON-NLS-1$
	                    if (this.input.read() != 240) {
	                    	log.append("\nERROR : waiting for SE command (240)\n"); //$NON-NLS-1$
	                    }
	                    log.append("SE\n"); //$NON-NLS-1$
	                    log.append("\t=> IAC SB TERMINAL-TYPE IS "+ this.term.getPhysicalTermType()+" IAC SE\n"); //$NON-NLS-1$ //$NON-NLS-2$
	                    final String mess = Character.toString((char) 255)+Character.toString((char) 250)+Character.toString((char) 24)+Character.toString((char) 0)+this.term.getPhysicalTermType()+Character.toString((char) 255)+Character.toString((char) 240);
	                    sendMessage(type, mess, log);
	                    closeMessageQueue(type);
	                }
	                    break;
	                
	                // case of NEW-ENVIRON
	                case (39) :
	                
	                    log.append("NEW-ENVIRON "); //$NON-NLS-1$
	                    final String type = "NEW-ENVIRON"; //$NON-NLS-1$
	                    
	                    if (this.input.read() != 1) {
	                    	log.append("\nERROR : waiting for SEND command (01)\n"); //$NON-NLS-1$
	                    }
	                    
	                    final StringBuilder out_string = new StringBuilder("\t=> IAC SB NEW-ENVIRON IS "); //$NON-NLS-1$
	                    String out = Character.toString((char) 255) + Character.toString((char) 250) + Character.toString((char) 39) + Character.toString((char) 0);
	                    
	                    char var_type = (char) this.input.read();
	                    
	                    while (var_type != 255) {
	                        char next = (char) this.input.read();
	                        switch (var_type) {
	                            case (0) :
	                                // variable
	                                if ((next > 3) && (next != 255)) {
	                                    // send just one variable
	                                    String var_name = ConstString.EMPTY;
	                                    String var_name_hex = ConstString.EMPTY;

	                                    while ((next > 3) && (next != 255)) {
	                
	                                        var_name += Character.toString(next);
	                                        var_name_hex += formatChar(next);
	                                        next = (char) this.input.read();
	                    
	                                    }
	                     
	                                    log.append("VAR "+var_name+"["+var_name_hex+"] "); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	       
	                                    if (this.envVar.containsKey(var_name)) {

	                                        out_string.append("VAR "+var_name+" VALUE "); //$NON-NLS-1$ //$NON-NLS-2$
	                                        out += Character.toString((char) 0)+var_name+Character.toString((char) 1);
	                                        out_string.append(this.envVar.get(var_name) + " "); //$NON-NLS-1$
	                                        out += this.envVar.get(var_name);
	                                    }
	                                } else {
	                                    // send all user variable
	                                    log.append("VAR "); //$NON-NLS-1$
	                                    for (final String name : this.envVar.keySet()) {
	                                    	final String value = this.envVar.get(name);
	                                         out_string.append("VAR "+name+" VALUE "+value+" "); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	                                        out += Character.toString((char) 0)+name+Character.toString((char) 1)+value;
	                                    }
	                                }
	                                break;
	                            case (3) :
	                                // user variable
	                                if ((next > 3) && (next != 255)) {
	                                    // send just one user variable
	                                    String uservar_name = ConstString.EMPTY;
	                                    String uservar_name_hex = ConstString.EMPTY;
	                                    while ((next > 3) && (next != 255)) {
	                                        uservar_name += Character.toString(next);
	                                        uservar_name_hex += formatChar(next);
	                                        next = (char) this.input.read();
	                                    }
	                                    log.append("USERVAR "+uservar_name+"["+uservar_name_hex+"] "); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	                                    if (this.usrVar.containsKey(uservar_name)) {
	                                        out_string.append("USERVAR "+uservar_name+" VALUE "); //$NON-NLS-1$ //$NON-NLS-2$
	                                        out += Character.toString((char) 3)+uservar_name+Character.toString((char) 1);
	                                        out_string.append(this.usrVar.get(uservar_name) + " "); //$NON-NLS-1$
	                                        out += this.usrVar.get(uservar_name);
	                                    }

	                                } else {
	                                    // send all user variable
	                                    log.append("USERVAR "); //$NON-NLS-1$
	                                    for (final String name : this.usrVar.keySet()) {
	                                    	final String value = this.usrVar.get(name);
	                                        out_string.append("USERVAR "+name+" VALUE "+value+" "); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	                                        out += Character.toString((char) 3)+name+Character.toString((char) 1)+value;
	                                    }
	                                }
	                                break;
	                            default :
	                                log.append("\nERROR : unknown type " + var_type + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
	                        }
	                        var_type = next;
	                    }
	                    
	                    log.append("IAC "); //$NON-NLS-1$
	                    if (this.input.read() != 240) {
	                    	log.append("\nERROR : waiting for SE command (240)\n"); //$NON-NLS-1$
	                    }
	                    log.append("SE\n"); //$NON-NLS-1$
	                    
	                    out_string.append("IAC SE\n"); //$NON-NLS-1$
	                    out += Character.toString((char) 255)+Character.toString((char) 240);
	                    
	                    sendMessage(type, out, out_string);

	                    closeMessageQueue(type);
	                    break;

	                default :
	                    log.append("ERROR : unknown code " + what + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
	            }
	             
	            break;
	            
	        case (251) :
	            log.append("WILL "); //$NON-NLS-1$
	            what = (char) this.input.read();
	            switch (what) {
	                  
	                case (0) :
	                    // BINARY
	                    log.append("BINARY\n"); //$NON-NLS-1$
	                    String type = "BINARY"; //$NON-NLS-1$
	                    this.serverProperties.setBinary(true);
	                    log.append("\t=> IAC WILL BINARY\n"); //$NON-NLS-1$
	                    log.append("\t=> IAC DO BINARY\n"); //$NON-NLS-1$
	                    String mess =  Character.toString((char) 255)+Character.toString((char) 251)+Character.toString((char) 0);
	                    mess += Character.toString((char) 255)+Character.toString((char) 253)+Character.toString((char) 0);
	                    sendMessage(type, mess, log);
	                    closeMessageQueue(type);
	                    break;
	                    
	                case (25) :
	                    // END-OF-RECORD
	                    log.append("END-OF-RECORD\n"); //$NON-NLS-1$
	                    type = "END-OF-RECORD"; //$NON-NLS-1$
	                    this.serverProperties.setEndOfRecord(true);
	                    log.append("\t=> IAC WILL END-OF-RECORD\n"); //$NON-NLS-1$
	                    log.append("\t=> IAC DO END-OF-RECORD\n"); //$NON-NLS-1$
	                    mess =  Character.toString((char) 255)+Character.toString((char) 251)+Character.toString((char) 25);
	                    mess += Character.toString((char) 255)+Character.toString((char) 253)+Character.toString((char) 25);
	                    sendMessage(type, mess, log);
	                    closeMessageQueue(type);
	                    break;

	                default :
	                     log.append("\nERROR : unknown type "+what+"\n"); //$NON-NLS-1$ //$NON-NLS-2$
	            }   
	            break;
	            
	        case (252) :
	            log.append("WON'T "); //$NON-NLS-1$
	            break;
	            
	        case (253) :
	            log.append("DO "); //$NON-NLS-1$
	            
	            what = (char) this.input.read();
	            switch (what) {

	                // case of END-OF-RECORD
	                case (0) :
	                    log.append("BINARY\n"); //$NON-NLS-1$
	                this.clientProperties.setBinary(true);
	                    break;
	            
	                // case of TERMINAL-TYPE
	                case (24) :

	                    log.append("TERMINAL-TYPE\n"); //$NON-NLS-1$

	                    String type = "TERMINAL-TYPE"; //$NON-NLS-1$
	                    log.append("\t=> IAC WILL TERMINAL-TYPE\n"); //$NON-NLS-1$
	                    String mess = Character.toString((char) 255) + Character.toString((char) 251) + Character.toString((char) 24);
	                    sendMessage(type, mess, log);
	                    break;                     
	                // case of END-OF-RECORD
	                case (25) :
	                    log.append("END-OF-RECORD\n"); //$NON-NLS-1$
	                	this.clientProperties.setEndOfRecord(true);
	                    break;
	                
	                // case of NEW-ENVIRON
	                case (39) :
	                    log.append("NEW-ENVIRON\n"); //$NON-NLS-1$
	                    type = "NEW-ENVIRON"; //$NON-NLS-1$
	                    log.append("\t=> IAC WILL NEW-ENVIRON\n"); //$NON-NLS-1$
	                    mess = Character.toString((char) 255) + Character.toString((char) 251) + Character.toString((char) 39);
	                    sendMessage(type, mess, log);
	                    break;
	                default :
	                    log.append("\nERROR : unknown code " + what + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
	            }
	            break;
	            
	        case (254) :
	            log.append("DON'T"); //$NON-NLS-1$
	            break;
	            
	        default :
	            log.append("\nERROR : unknown code " + Character.toString(query) + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
	    }
	}

	/**
	 * Method to read from the server. The display screen is modified according to reed data.
	 * 
	 * @param log Log stringBuilder.
	 * @throws IOException I/O error 
	 */
	private void read(final StringBuilder log) throws IOException {
	    boolean nego = true;
	    this.reading = true;
	    while (this.reading) {

	        char ch = (char) this.input.read();

	        if ((ch != 255) && nego) {
	            nego = false;
	            final int len = (ch * 256) + this.input.read();
	            log.append("Length = " + len + "\n"); //$NON-NLS-1$ //$NON-NLS-2$

	            for (int i = 0; i < 7; ++i) {
	                log.append(formatChar(this.input.read()) + " "); //$NON-NLS-1$
	            }    
	            final char opcode = (char) this.input.read();
	            log.append("\nopCode = "+opcode+"\n"); //$NON-NLS-1$ //$NON-NLS-2$
	            ch = (char) this.input.read();
	        }


	        
	        switch (ch) {
	        
	            case (1) :
	                log.append("<= SOH "); //$NON-NLS-1$
	                int len = this.input.read();
	                log.append(formatChar(len));
	                if ((len > 7) || (len == 0)) {
	                	len = 4;
	                }
	                if (len > 0) {
	                	log.append(formatChar(this.input.read()));
	                }
	                if (len > 1) {
	                	log.append(formatChar(this.input.read()));
	                }
	                if (len > 2) {
	                	log.append(formatChar(this.input.read()));
	                }
	                final char error_line = (char) this.input.read();
	                log.append(formatChar(error_line));
	                for (int i = 2; i >= 0; i--) {
	                    char flag = 255;
	                    if (len > (6 - i)) {
	                        flag = (char) this.input.read();
	                        log.append(formatChar(flag));
	                    }
	                    for (int j = 7; j >=0; j--) {
	                    	this.screenDesc.getFunctionKey().put("F"+Integer.toString(1+j+(8*i)), Boolean.valueOf(((flag >> j) & 1) == 1)); //$NON-NLS-1$
	                    }
	                }
	                log.append("\n"); //$NON-NLS-1$
	                break;

	            case (2) :
	                log.append("<= REPEAT "); //$NON-NLS-1$
	                final int to_y = this.input.read();
	                final int to_x = this.input.read();
	                char todo = (char) this.input.read();
	                if (todo > 32) {
	                    todo = this.term.decode(todo);
	                }
	                log.append("toY=\""+to_y+"\" toX=\""+to_x+"\" todo=\""+todo+"\"\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
					if (this.textSend == 1) {
						this.textSend = 0;
					}
	                break;
	                            case (4) :
	                log.append("<= ESC "); //$NON-NLS-1$
	                char what = (char) this.input.read();
	                switch (what) {

	                    case (17) :
	                        log.append("WRITE TO DISPLAY\n"); //$NON-NLS-1$
	                    this.wtd = true;
	                        {
	                        	final char control_char_0 = (char) this.input.read(); //NOPMD
	                        	final char control_char_1 = (char) this.input.read(); //NOPMD
	                        }
	                        break;
	                    
	                    case (64) :
	                        log.append("CLEAR UNIT\n"); //$NON-NLS-1$
	                    	this.moveToSend = false;
							this.textSend = 0;
							clearScreen();
	                        break;

	                    case (82) :
	                        log.append("READ MTD\n"); //$NON-NLS-1$
	                        {
	                        	final char control_char_0 = (char) this.input.read(); //NOPMD
	                        	final char control_char_1 =(char)  this.input.read(); //NOPMD
	                        }
	                        break;
	                    
	                    case (130) :
	                        log.append("READ MTD\n"); //$NON-NLS-1$
	                        {
	                        	final char control_char_0 = (char) this.input.read(); //NOPMD
	                        	final char control_char_1 =(char)  this.input.read(); //NOPMD
	                        }
	                        break;
	                    
	                    case (243) :
	                        log.append("QUERY (WSF)\n"); //$NON-NLS-1$
	                        len = (this.input.read() * 256) + this.input.read() - 2;
	                        log.append("len = "+len+"\n"); //$NON-NLS-1$ //$NON-NLS-2$
	                        for (int i=0; i<len; i++) {
	                            log.append(formatChar(this.input.read()));
	                        }
	                        log.append("\n"); //$NON-NLS-1$
	                        answerToWSF(log);
	                        break;
	                        
	                    default :
	                        log.append("??? ["+what+"]\n"); //$NON-NLS-1$ //$NON-NLS-2$
	                }
	                break;
	                
	            case (17) :
	            	this.screenY = this.input.read() - 1;
	            	this.screenX = this.input.read() - 1;
	                log.append("<= MOVE TO ["+this.screenY+";"+this.screenX+"] '"+this.moveToSend+"' \n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
					if (this.moveToSend && (this.textSend == 1)) {
						this.textSend = 0;
					}
					this.moveToSend = true;
	                break;
	                
	            case (29) :
	                log.append("<= Start of Field Order "); //$NON-NLS-1$
	                what = (char) this.input.read();
	                if ((what & 0x40) == 0) {
	                	this.col = CharacterColor.findColor((char) this.input.read());
	                	len = (this.input.read() * 256) + this.input.read();
	                	if (this.textSend == 1) {
	                		this.textSend = 0;
	                	}
	                } else {
	                	final FieldProperties field = new FieldProperties(); //NOPMD
	                    log.append("FFW "); //$NON-NLS-1$
	                    field.setActive(true);
	                    field.setFfw0(what);
	                    field.setFfw1((char) this.input.read());
	                    
	                    what = (char) this.input.read();
	                    if ((what & 0x80) != 0) {
	                        log.append("FCW "); //$NON-NLS-1$
		                    field.setFcw0(what);
		                    field.setFcw1((char) this.input.read());
	                        what = (char) this.input.read();
	                    }

	                    this.col = CharacterColor.findColor(what);
	                    len = (this.input.read() * 256) + this.input.read();
	                    field.setColor(this.col);
	                    field.setLength(len);
	                    
	                    this.screenDesc.getFields().add(field);
						if (this.textSend == 1) {
							this.textSend = 0;
						}
	                }
	                break;
	                
	            case (255) :
	                final char esc_ch = (char) this.input.read();
	                if (esc_ch == 255) {
	                    treatData(esc_ch, log);
	                } else {
	                    answerIAC(esc_ch, log);
	                }
	                break;
	                
	            default :
	                if ((ch >= 0x20) && (ch<40)) {
	                	this.col = CharacterColor.findColor(ch);
	                    log.append("<= COLOR "+this.col.colorFont.htmlCode+"\n"); //$NON-NLS-1$ //$NON-NLS-2$
						if (this.textSend == 1) {
							this.textSend = 0;
						}
	                } else {
	                    treatData(ch, log);
	                }
	        }

	    }
		if (this.moveToSend) {
			this.moveToSend = false;
		}

	}

	/**
	 * Method to read the screen from the socket. 
	 * 
	 * @throws IOException I/O error 
	 */
	public void readScreen() throws IOException {
		final StringBuilder log = new StringBuilder();
	    this.wtd = false;
	    while (!this.wtd) {
	    	this.moveToSend = false;
	    	this.textSend = 0;
	        read(log);
	    }
	    LOG.info(log.toString());
	}

	/**
	 * Sending message method
	 * 
	 * @param type Type
	 * @param mess Message
	 * @param log Logger
	 * @throws IOException I/O error
	 */
	private void sendMessage(final String type, final String mess, final StringBuilder log) throws IOException {
/*	    if (!screenDesc.getQueues().containsKey(type)) {
	        final QueueProperties queue = new QueueProperties();
	        queue.setMessage(ConstString.EMPTY);
	        queue.setLog(ConstString.EMPTY);
	        queue.setType(type);
	        queue.setStatus("open");
	        this.screenDesc.getQueues().put(type, queue);
	    }
	    final int num = tn5250["connexion"]["queue"]["open"][type];
	    if (num == tn5250["connexion"]["queue"]["current"]) {*/
	    	for (char ch : mess.toCharArray()) {
	    		this.output.write(ch);
	    	}
	    	this.output.flush();
	        //echo log;
/*	    }
	    final QueueProperties queue = this.screenDesc.getQueues().get(type);
	    queue.setMessage(queue.getMessage() + mess);
	    queue.setLog(queue.getLog() + log);*/
	}

	/**
	 * Close queue and send messages
	 * 
	 * @param type Type of message
	 * @return true if the close operation has no error.
	 */
	//FIXME ???
	private boolean closeMessageQueue(final String type) {
/*	    
	    if (!screenDesc.getQueues().containsKey(type)) {
	        return false;
	    }
	    num = tn5250["connexion"]["queue"]["open"][type];
	    unset(tn5250["connexion"]["queue"]["open"][type]);
	    tn5250["connexion"]["queue"]["queue"][num]["status"] = "closed";

	    if (num == tn5250["connexion"]["queue"]["current"]) {
	        boolean loop = false;
	        do {
	            tn5250["connexion"]["queue"]["current"]++;
	            tn5250["connexion"]["queue"]["length"]--;
	            if (tn5250["connexion"]["queue"]["length"] > 0) {
	                num++;
	                for (final char ch : tn5250["connexion"]["queue"]["queue"][num]["message"]) {
	                	output.write(ch);
	                }
	                output.flush();
	                //echo tn5250["connexion"]["queue"]["queue"][num]["log"];
	                loop = (tn5250["connexion"]["queue"]["queue"][num]["status"] == "closed");
	            } else {
	                loop = false;
	            }
	        } while (loop);
	    }*/
	    return true;
	}

	/**
	 * Send message to the host
	 * 
	 * @param text Test
	 * @param opcode Operation code
	 * @param log Logger
	 * @throws IOException I/O error
	 */
	private void sendToHost(final String text, final String opcode, final StringBuilder log) throws IOException {
	    final int len = text.length() + 10;
	    Character.toString((char) ((len >> 8) & 0xFF));
	    Character.toString((char) (len & 0xFF));
	    Character.toString((char) 0x12);
	    Character.toString((char) 0xA0);
	    Character.toString((char) 0x00);
	    Character.toString((char) 0x00);
	    Character.toString((char) 0x04);
	    Character.toString((char) 0x00);
	    Character.toString((char) 0x00);
	    Character.toString(opCodeMap.get(opcode).charValue());
	    for (final char ch : text.toCharArray()) {
	        this.output.write(ch);
	    }
	    Character.toString((char) 0xFF);
	    Character.toString((char) 0xEF);
	    this.output.flush();
	}


	/**
	 * Answer to server WSF request
	 * 
	 * @param log Logger
	 * @throws IOException I/O error
	 */
	private void answerToWSF(final StringBuilder log) throws IOException{

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

	    final String dev_type  = this.term.getPhysicalTermType().substring(4, 8);
	    String dev_model = Character.toString((char) 0) + this.term.getPhysicalTermType().substring(9);

	    if (dev_model.length() == 2) {
	    	dev_model = Character.toString((char) 0)+dev_model;
	    }

	    answer += this.term.encode(dev_type+dev_model);

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

	    sendToHost(answer, "NoOperation", log); //$NON-NLS-1$
	}

}
