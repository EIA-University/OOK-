import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.server.ServerNotActiveException;
import java.util.Stack;

//profe este código no compila los saltos que hace el Ook, yo estaba pensando en re-hacerlo si algo lo acualizo
public class Sierris {
	public static String leerFichero(String ruta) throws IOException {
		FileReader file = new FileReader(ruta);
		BufferedReader bf = new BufferedReader(file);
		String cadena, cad = "";
		while ((cadena = bf.readLine()) != null) {
			cad = cadena;
			cadena += bf.readLine();
		}
		return cad;
	}

	public static void Ook(String cadena) {
		double[] ascii = new double[800];
		String[] sentencia = cadena.split(" ");
		String[] sentencia1 = new String[sentencia.length / 2];

		// Stack<String> sentencia1 = new Stack<String>();

		int i = 0;
		int k = 0;
		while (i < sentencia.length - 1 && k < sentencia.length - 1) {

			sentencia1[i] = sentencia[k] + " " + sentencia[k + 1];
			i++;
			k = k + 2;

		}

		/*
		 * while(i<sentencia.length-1){ sentencia1.push(sentencia[i]+ " " +
		 * sentencia[i+1]); i+=2; }
		 */

		hacer(sentencia1, 0, -1, ascii);
		// return ascii;

	}

	/*
	 * public static double[] hacer2(Stack<String> pila){ int i=0, j=0, z=0;
	 * String valor;
	 * 
	 * String[] auxiliar = new String[100];//auxiliar que almacena 
	 * los comandos
	 * a repetir int numRepet; //numero de repeticiones
	 * 
	 * while(i<pila.size()){ valor = pila.pop(); if(valor.compareTo("Ook. Ook."
	 * )==0){ if(j==-1){ j++; } ascii[j] =ascii[j] +1; }else if(valor.compareTo(
	 * "Ook! Ook!")==0){ ascii[j]=ascii[j]-1; }else if(valor.compareTo(
	 * "Ook. Ook?")==0){ j++; }else if(valor.compareTo("Ook? Ook.")==0){ j--;
	 * }else if(valor.compareTo("Ook! Ook.")==0){ System.out.print((char)
	 * ascii[j]); }else if(valor.compareTo("Ook! Ook?")==0){ auxiliar[z]=valor;
	 * numRepet=j; while(numRepet!=0){
	 * 
	 * } z++; }
	 * 
	 * 
	 * } return ascii;
	 * 
	 * }
	 */

	public static double[] hacer(String[] sentencias, int z, int j, double[] ascii) {
		// double[] ascii= new double[800];
		// boolean valor = true;
		int repeticiones=0, guardaZ=0, guardaJ=0;
		
		while (z < sentencias.length) {
			if (sentencias[z].compareTo("Ook. Ook.") == 0) {
				if (j == -1) {
					j++;
				}
				ascii[j] = ascii[j] + 1;
			} else if (sentencias[z].compareTo("Ook! Ook!") == 0) {
				ascii[j] = ascii[j] - 1;
				//repeticiones--;
			} else if (sentencias[z].compareTo("Ook. Ook?") == 0) {
				j++;
			} else if (sentencias[z].compareTo("Ook? Ook.") == 0) {
				j--;
			} else if (sentencias[z].compareTo("Ook! Ook.") == 0) {
				System.out.print((char) ascii[j]);
			} else if (sentencias[z].compareTo("Ook! Ook?") == 0) {
				
			} else if (sentencias[z].compareTo("Ook? Ook!") == 0) {
				
			}

			z++;
		}
		return ascii;

	}

	public static void main(String[] args) {
		System.out.print(System.getProperty("user.dir")+"/ook.txt\n");
		try {
			Ook(leerFichero(System.getProperty("user.dir")+"/ook.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
