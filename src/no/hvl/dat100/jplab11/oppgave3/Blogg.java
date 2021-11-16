package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

public class Blogg{

	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg () {
		innleggtabell = new Innlegg[20];
		
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		
	}

	public int getAntall() {
		return nesteledig;
	}

	public Innlegg[] getSamling() {
		return innleggtabell;
	}

	public int finnInnlegg(Innlegg innlegg) {
		int s = -1;

		for(int i =0; i<nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				s = i;
			}
		}
		return s;
	}

	public boolean finnes(Innlegg innlegg) {
		boolean finnes = false;
		
		if (finnInnlegg(innlegg) != -1) {
			finnes = true;
		}
		return finnes;
	}

	public boolean ledigPlass() {
		
		return nesteledig < innleggtabell.length && innleggtabell[nesteledig] == null;
	}

	public boolean leggTil(Innlegg innlegg) {

		boolean ny = finnes(innlegg);
	
		if (!ny) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			ny= true;

		} 
		return ny;
	}
		public String toString() {
		

		String data = nesteledig + "\n";
		
		for(int i =0; i<nesteledig;i++) {
			data+= innleggtabell[i].toString();
		}
			
		
		return data;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] innlegg = new Innlegg[2*innleggtabell.length];
		for (int i =0; i<nesteledig;i++) {
			
			innlegg[i] = innleggtabell[i];
			innleggtabell[i]= null;
			
			
		}
		innleggtabell = innlegg;
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean leggtil = false;
		int i =0;
		
		while (i<innleggtabell.length && !leggtil) {
			if(innleggtabell[i].getId() == innlegg.getId()) {
				i++;
			}else {
				innleggtabell[nesteledig]= innlegg;
				nesteledig++;
				leggtil= true;
			}
			
		}

		return leggtil;
	}

	public boolean slett(Innlegg innlegg) {
		boolean slett = false;
		int i =0;
		while( i<nesteledig && !slett) {
			if(innleggtabell[i].getId() == innlegg.getId()) {
				innleggtabell[i]=null;
				nesteledig--;
			}else {
				i++;
			}
		}
		if (slett) {
			slett = true;
		}
		
		
		return slett;
	}

	public int[] search(String user, String ord) {
		int[] tab = new int[nesteledig];
		
		for (int i =0; i<nesteledig;i++) {
			if(user == innleggtabell[i].getBruker()) {
				tab[i]= innleggtabell[i].getId(); 
			}
		}
		return tab;
		//throw new UnsupportedOperationException(TODO.method());

	}
}