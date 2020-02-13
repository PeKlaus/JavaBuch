package gui10;

public class Artikel
{
	private String artikelnummer;
	private String artikelbezeichnung;
	private double stueckpreis;
	
	public Artikel(String nr, String bez, double sp)
	{
		artikelnummer = nr;
		artikelbezeichnung = bez;
		stueckpreis = sp;
	}
	
	public String getArtikelnummer()
	{
		return artikelnummer;
	}
	
	public String getArtikelbezeichnung()
	{
		return artikelbezeichnung;
	}
	
	public double getStueckpreis()
	{
		return stueckpreis;
	}
	
	public void setArtikelnummer(String nr)
	{
		artikelnummer = nr;
	}
	
	public void setArtikelbezeichnung(String bez)
	{
		artikelbezeichnung = bez;
	}
	
	public void setStueckpreis(double sp)
	{
		stueckpreis = sp;
	}

}
