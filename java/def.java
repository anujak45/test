class gaListener extends WindowAdapter
{
	public void windowClosing(WindowEvent closeNotepad)
	{
		System.exit(0);
	}
}
Class new_op implements ActionListener
{
	public void actionPerformed(AcetionEvent new)
	{
		ta1.setText(" ");
	}
}
Class open_op implements ActionListener
{
	public void actionPerformed(AcetionEvent open)
	{
		FileDialog fd1=new FileDialog(Notepad.this,"select a text file",FileDialog.LOAD);
		fd1.show();
		if(fd1.getFile()!=NULL)
		{
			fn1=fd1.getDirectory()+fd1.getFile();
			setTitle(fn1);
			ReadFile();
		}
		ta1.requestFocus();
	}
}
Class close_op implements ActionListener
{
	public void actionPerformed(AcetionEvent close)
	{
		System.exit(0);
	}
}
Class save_op implements ActionListener
{
	public void actionPerformed(AcetionEvent save)
	{
		FileDialog fd1=new FileDialog(Notepad.this,"select a text file",FileDialog.LOAD);
		fd1.show();
		if(fd1.getFile()!=NULL)
		{
			fn1=fd1.getDirectory()+fd1.getFile();
			
		}	
	}
}
