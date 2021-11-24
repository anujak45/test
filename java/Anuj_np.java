import java.io.*;
import java.awt.datatransfer.*;
import java.awt.*;
import java.awt.event.*;
class Anuj_np extends Frame
{
	Clpiboard cb1=getToolkit().getSystemClipboard();
	TextArea ta1;
	String fname;
	np()
	{
		gaListener gl1=new gaListener();
		addWindowListener(gl1);
	}
}