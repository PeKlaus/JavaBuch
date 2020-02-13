package uebung05;

/*
 * Klasse Rechteck
 * @author Hans-Peter Habelitz
 * @date 2011-12-21
 */

public class Rechteck {
    double laenge, breite;

    Rechteck() {
	laenge = 0;
	breite = 0;
    }

    Rechteck(double l, double b) {
	laenge = l;
	breite = b;
    }

    void setLaenge(double l) {
	laenge = l;
    }

    void setBreite(double b) {
	breite = b;
    }

    void setSeiten(double l, double b) {
	laenge = l;
	breite = b;
    }

    double getLaenge() {
	return laenge;
    }

    double getBreite() {
	return breite;
    }

    double getLangeSeite() {
	if (laenge > breite)
	    return laenge;
	else
	    return breite;
    }

    double getKurzeSeite() {
	if (laenge > breite)
	    return breite;
	else
	    return laenge;
    }

    double getDiagonale() {
	return Math.sqrt(laenge * laenge + breite * breite);
    }

    double getUmfang() {
	return 2 * laenge + 2 * breite;
    }

    double getFlaeche() {
	return laenge * breite;
    }

    void laengeAusgeben() {
	double laenge = 5.4;
	System.out.println("Länge: " + laenge);
    }

    void laengeVergroessern(double dl) {
	laenge += dl;
    }

    void breiteVergroessern(double db) {
	breite += db;
    }

    void laengeVerkleinern(double dl) {
	laenge -= dl;
    }

    void breiteVerkleinern(double db) {
	breite -= db;
    }
}
