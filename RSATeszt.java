import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RSATeszt{
	
	public static void main(String args[]){
		try{
		
			
			BufferedReader inputStream = new BufferedReader(new FileReader(args[0]));
			String line = null;
			List<String> lines = new ArrayList<String>();
			int sorokSzama = 0;
			
			while((line = inputStream.readLine()) != null){
				lines.add(line);
				sorokSzama++;
			}
			inputStream.close();
			
			
			BufferedReader betu = new BufferedReader(new FileReader("angol.txt"));
			
			char[] gyakorisag = new char[50];
			int betukSzama = 0;
			line = null;
			
			while((line = betu.readLine()) != null){
				gyakorisag[betukSzama] = line.charAt(0);
				betukSzama++;
			}
			betu.close();
			
			Jel buff[]= new Jel[sorokSzama];
			int elemek = 0;
			buff[elemek] = new Jel(lines.get(0));
			elemek++;
			boolean talalt = false;
			
			
			for(int i = 1; i < sorokSzama; i++ )
			{
				talalt = false;
					for(int j = 0; j < elemek; j++)
					{
						if(buff[j].getValue().compareTo(lines.get(i)) == 0)
						{
							buff[j].incElofordulas();
							talalt = true;
						}
					}	
					
					if(!talalt){
						buff[elemek] = new Jel(lines.get(i));
						elemek++;				
					
					}
					
				
			}

			
			for(int i = 0; i < elemek; i++)
				System.out.println(buff[i].getElofordulas());
			
			
			for(int i = 0; i < elemek - 1; i++)
			{
				for(int j = i+1; j < elemek; j++)
				{
					if(buff[i].getElofordulas() < buff[j].getElofordulas())
					{
						Jel temp1 = new Jel(buff[i].getValue());
						temp1.setElofordulas(buff[i].getElofordulas());
						buff[i] = buff[j];
						buff[j] = temp1;
					}
				}
			}
			
			for(int i = 0; i < elemek; i++)
				System.out.println(buff[i].getElofordulas());
			
			 
			
			for(int i = 0; i < gyakorisag.length; i++){
				buff[i].setChar(gyakorisag[i]);
			}
			
			
			
			for(String line1 : lines)
			{
				for(int i = 0; i < elemek; i++)
					if(line1.compareTo(buff[i].getValue()) == 0 )
					{
						System.out.print(buff[i].getChar());
					}
			}

			System.out.println();

		
		} catch(IOException e)
		{}
	}
}