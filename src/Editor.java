import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class Editor extends JFrame{
	int fontSize=14;
	final JTextPane textPane = new JTextPane();
	int fileToOpen;
	int fileToSave;
	JFileChooser fileOpen;
	JFileChooser fileSave;
	Editor(){
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu file = new JMenu("File");
		menuBar.add(file);
		JMenuItem newOption = new JMenuItem("New");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem close = new JMenuItem("Exit");
		file.add(newOption);
		file.add(open);
		file.add(save);
		file.add(close);
		JMenu size = new JMenu("Font Size");
		JMenuItem textSize1 = new JMenuItem("10");
		JMenuItem textSize2 = new JMenuItem("15");
		JMenuItem textSize3 = new JMenuItem("20");
		JMenuItem textSize4 = new JMenuItem("30");
		JMenuItem textSize5 = new JMenuItem("40");
		JMenuItem textSize6 = new JMenuItem("50");
		JMenuItem textSize7 = new JMenuItem("60");
		size.add(textSize1);
		size.add(textSize2);
		size.add(textSize3);
		size.add(textSize4);
		size.add(textSize5);
		size.add(textSize6);
		size.add(textSize7);
		menuBar.add(size);
		JMenu color=new JMenu("Color");
		JMenuItem color1 = new JMenuItem("Red");
		JMenuItem color2 = new JMenuItem("Blue");
		JMenuItem color3 = new JMenuItem("Green");
		JMenuItem color4= new JMenuItem("Magenta");
		color.add(color1);
		color.add(color2);
		color.add(color3);
		color.add(color4);
		menuBar.add(color);
		JMenu font=new JMenu("Font Style");
		JMenuItem font1 = new JMenuItem("Baskerville");
		JMenuItem font2 = new JMenuItem("Comic Sans MS");
		JMenuItem font3 = new JMenuItem("Lucida Sans");
		JMenuItem font4= new JMenuItem("Times New Roman");
		font.add(font1);
		font.add(font2);
		font.add(font3);
		font.add(font4);
		menuBar.add(font);

		font1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Font font = new Font("Baskerville", Font.PLAIN, 20);
				textPane.setFont(font);
			}
		});
		font2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Font font = new Font("Comic Sans MS", Font.PLAIN, 20);
				textPane.setFont(font);
			}
		});
		font3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Font font = new Font("Lucida Sans", Font.PLAIN, 20);
				textPane.setFont(font);
			}
		});
		font4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Font font = new Font("Times New Roman", Font.PLAIN, 20);
				textPane.setFont(font);
			}
		});

		color1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StyledDocument doc = textPane.getStyledDocument();
				int start = textPane.getSelectionStart();
				int end = textPane.getSelectionEnd();
				Style style;
				if (start == end) { 
					return;
				}
				if (start > end) { 
					int life = start;
					start = end;
					end = life;
				}
				style = textPane.addStyle("Monospaced", null);
				StyleConstants.setForeground(style, Color.RED.darker());
				doc.setCharacterAttributes(start, end - start, style, false);
			}
		});

		color2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StyledDocument doc = textPane.getStyledDocument();
				int start = textPane.getSelectionStart();
				int end = textPane.getSelectionEnd();
				Style style;
				if (start == end) { 
					return;
				}
				if (start > end) { 
					int life = start;
					start = end;
					end = life;
				}
				style = textPane.addStyle("Monospaced", null);
				StyleConstants.setForeground(style, Color.BLUE.darker());
				doc.setCharacterAttributes(start, end - start, style, false);
			}
		});
		color3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StyledDocument doc = textPane.getStyledDocument();
				int start = textPane.getSelectionStart();
				int end = textPane.getSelectionEnd();
				Style style;
				if (start == end) { 
					return;
				}
				if (start > end) { 
					int life = start;
					start = end;
					end = life;
				}
				style = textPane.addStyle("Monospaced", null);
				StyleConstants.setForeground(style, Color.GREEN.darker());
				doc.setCharacterAttributes(start, end - start, style, false);
			}
		});
		color4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StyledDocument doc = textPane.getStyledDocument();
				int start = textPane.getSelectionStart();
				int end = textPane.getSelectionEnd();
				Style style;
				if (start == end) { 
					return;
				}
				if (start > end) { 
					int life = start;
					start = end;
					end = life;
				}
				style = textPane.addStyle("Monospaced", null);
				StyleConstants.setForeground(style, Color.MAGENTA.darker());
				doc.setCharacterAttributes(start, end - start, style, false);
			}
		});
		textSize1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = textPane.getSelectedText();
				int start = textPane.getSelectionStart();
				int end = textPane.getSelectionEnd();
				if (start == end) { 
					return;
				}
				if (start > end) { 
					int life = start;
					start = end;
					end = life;
				}
				StyleContext context = new StyleContext();
				Style style;

				textPane.replaceSelection("");

				style = context.addStyle("mystyle", null);
				style.addAttribute(StyleConstants.FontSize, new Integer(10));
				try {
					textPane.getStyledDocument().insertString(start, text, style);
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}	
			}
		});
		textSize2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = textPane.getSelectedText();
				int start = textPane.getSelectionStart();
				int end = textPane.getSelectionEnd();
				if (start == end) { 
					return;
				}
				if (start > end) { 
					int life = start;
					start = end;
					end = life;
				}
				StyleContext context = new StyleContext();
				Style style;

				textPane.replaceSelection("");

				style = context.addStyle("mystyle", null);
				style.addAttribute(StyleConstants.FontSize, new Integer(15));
				try {
					textPane.getStyledDocument().insertString(start, text, style);
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}	
			}
		});
		textSize3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = textPane.getSelectedText();
				int start = textPane.getSelectionStart();
				int end = textPane.getSelectionEnd();
				if (start == end) { 
					return;
				}
				if (start > end) { 
					int life = start;
					start = end;
					end = life;
				}
				StyleContext context = new StyleContext();
				Style style;

				textPane.replaceSelection("");

				style = context.addStyle("mystyle", null);
				style.addAttribute(StyleConstants.FontSize, new Integer(20));
				try {
					textPane.getStyledDocument().insertString(start, text, style);
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}	
			}
		});
		textSize4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = textPane.getSelectedText();
				int start = textPane.getSelectionStart();
				int end = textPane.getSelectionEnd();
				if (start == end) { 
					return;
				}
				if (start > end) { 
					int life = start;
					start = end;
					end = life;
				}
				StyleContext context = new StyleContext();
				Style style;

				textPane.replaceSelection("");

				style = context.addStyle("mystyle", null);
				style.addAttribute(StyleConstants.FontSize, new Integer(30));
				try {
					textPane.getStyledDocument().insertString(start, text, style);
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}	
			}
		});
		textSize5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = textPane.getSelectedText();
				int start = textPane.getSelectionStart();
				int end = textPane.getSelectionEnd();
				if (start == end) { 
					return;
				}
				if (start > end) { 
					int life = start;
					start = end;
					end = life;
				}
				StyleContext context = new StyleContext();
				Style style;

				textPane.replaceSelection("");

				style = context.addStyle("mystyle", null);
				style.addAttribute(StyleConstants.FontSize, new Integer(40));
				try {
					textPane.getStyledDocument().insertString(start, text, style);
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}	
			}
		});
		textSize6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = textPane.getSelectedText();
				int start = textPane.getSelectionStart();
				int end = textPane.getSelectionEnd();
				if (start == end) { 
					return;
				}
				if (start > end) { 
					int life = start;
					start = end;
					end = life;
				}
				StyleContext context = new StyleContext();
				Style style;

				textPane.replaceSelection("");

				style = context.addStyle("mystyle", null);
				style.addAttribute(StyleConstants.FontSize, new Integer(50));
				try {
					textPane.getStyledDocument().insertString(start, text, style);
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}	
			}
		});
		textSize7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = textPane.getSelectedText();
				StyleContext context = new StyleContext();
				Style style;
				int start = textPane.getSelectionStart();
				int end = textPane.getSelectionEnd();
				if (start == end) { 
					return;
				}
				if (start > end) { 
					int life = start;
					start = end;
					end = life;
				}
				textPane.replaceSelection("");

				style = context.addStyle("mystyle", null);
				style.addAttribute(StyleConstants.FontSize, new Integer(60));
				try {
					textPane.getStyledDocument().insertString(start, text, style);
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}	
			}
		});

		JMenu edit = new JMenu("Edit");
		menuBar.add(edit);

		Action cutAction = new DefaultEditorKit.CutAction();
		cutAction.putValue(Action.NAME, "Cut");
		edit.add(cutAction);
		Action copyAction = new DefaultEditorKit.CopyAction();
		copyAction.putValue(Action.NAME, "Copy");
		edit.add(copyAction);
		Action pasteAction = new DefaultEditorKit.PasteAction();
		pasteAction.putValue(Action.NAME, "Paste");
		edit.add(pasteAction);
		getContentPane().add(textPane);

		newOption.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				textPane.setText("");
			}
		});

		open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				openFile();
				if (fileToOpen == JFileChooser.APPROVE_OPTION){
					textPane.setText(readFile(fileOpen.getSelectedFile().getAbsolutePath()));
				}
			}
		});

		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				saveFile();
				if (fileToSave == JFileChooser.APPROVE_OPTION){
					try {
						BufferedWriter out = new BufferedWriter(new FileWriter(fileSave.getSelectedFile().getPath()));
						out.write(textPane.getText());
						out.close();
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			}
		});

		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});

	}
	public void openFile(){
		JFileChooser open = new JFileChooser();
		int option = open.showOpenDialog(this);
		fileToOpen = option;
		fileOpen = open;
	}

	public void saveFile(){
		JFileChooser save = new JFileChooser();
		int option = save.showSaveDialog(this);
		fileToSave = option;
		fileSave = save;
	}
	private String readFile(String fileName)
	{
		String records = new String();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			while((line = reader.readLine())!=null)
			{
				records+=line;
			}
			reader.close();
			return records;
		}
		catch(Exception e)
		{
			System.err.format("Exception occurred while trying to read '%s'.",fileName);
			e.printStackTrace();
			return null;
		}
	}
	
	
}