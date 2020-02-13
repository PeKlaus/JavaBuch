package gui10;

/* Klasse Bruch
 * @author Hans-Peter Habelitz
 * @date 2011-12-21
 */

class Bruch implements Comparable {
    int zaehler;
    int nenner;

    Bruch() {
	zaehler = 0;
	nenner = 1;
    }

    Bruch(int x) {
	zaehler = x;
	nenner = 1;
    }

    Bruch(int x, int y) {
	zaehler = x;
	nenner = y;
    }
    
    void setZaehler(int z) {
	zaehler = z;
    }

    void setNenner(int n) {
	nenner = n;
    }

    int getZaehler() {
	return zaehler;
    }

    int getNenner() {
	return nenner;
    }

    String bruchToString() {
	return zaehler + "/" + nenner;
    }

    void ausgeben() // Kopf der Methode ausgeben
    {
	System.out.print(zaehler + "/" + nenner); // Rumpf der Methode ausgeben
    }

    void kuerzen() {
	int m, n, r; // lokale Variablen
	m = Math.abs(zaehler); // speichert in m den Betrag von zaehler
	n = Math.abs(nenner);  // speichert in n den Betrag von nenner
	r = m % n;
	while (r > 0) {
	    m = n;
	    n = r;
	    r = m % n;
	}
	zaehler /= n; // in n steht jetzt der ggT
	nenner /= n;
    }

    void gekuerztausgeben() {
	kuerzen();
	ausgeben();
    }

    double dezimalwert() {
	return (double) zaehler / nenner;
    }
    
 /*   boolean equals(Bruch b) {
	if (this.dezimalwert() == b.dezimalwert()) {
	    return true;
	}
	else {
	    return false;
	}
    }*/

    Bruch addiere(Bruch b) {
	int z = zaehler * b.nenner + b.zaehler * nenner;
	int n = nenner * b.nenner;
	Bruch summe = new Bruch(z, n);
	return summe;
    }

    Bruch subtrahiere(Bruch b) {
	int z = zaehler * b.nenner - b.zaehler * nenner;
	int n = nenner * b.nenner;
	Bruch differenz = new Bruch(z, n);
	return differenz;
    }
    
    Bruch multipliziere(Bruch m) {
	int z = zaehler * m.zaehler;
	int n = nenner * m.nenner;
	Bruch produkt = new Bruch(z, n);
	return produkt;
    }

    int signum() {
	if (this.dezimalwert() == 0) {
	    return 0;
	}
	if (this.dezimalwert() > 0) {
	    return 1;
	}
	return -1;
    }

    boolean equals(Bruch x) {
	Bruch a = new Bruch(this.zaehler, this.nenner);
	Bruch b = new Bruch(x.zaehler, x.nenner);
	a.kuerzen();
	b.kuerzen();
	if ((a.zaehler == b.zaehler) && (a.nenner == b.nenner)) {
	    return true;
	} else {
	    return false;
	}
    }

    @Override
    public int compareTo(Object o) {
	// TODO Auto-generated method stub
	// Rückgabewert
        int compareValue =-2;
        // Typumwandlung zur Klasse Bruch
        Bruch compareBruch = (Bruch) o;
        // Vergleich auf Gleichheit
        if(this.equals(compareBruch))
        {
            compareValue = 0;
        }
        // Vergleich auf kleiner
        if(this.dezimalwert() < compareBruch.dezimalwert())
        {
            compareValue = -1;
        }
        // Vergleich auf größer
        if(this.dezimalwert() > compareBruch.dezimalwert())
        {
            compareValue = 1;
        }
        return compareValue;
    }
    
}