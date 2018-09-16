package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> contagem = new LinkedHashMap<>();
		
		System.out.print("Enter file full path: ");
		String strPath = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(strPath))){
			
			String line = br.readLine();
			while(line != null) {
				String[] vector = line.split(",");
				String name = vector[0];
				int value = Integer.parseInt(vector[1]);
				
				if(contagem.containsKey(name)) {
					int sum = contagem.get(name);
					sum += value;
					contagem.put(name, sum);
				}else {				
				contagem.put(name, value);
				}
				
				line = br.readLine();
			}
			
			for(String can : contagem.keySet()) {
				System.out.println(can + ": " + contagem.get(can));
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}

		sc.close();
	}

}
