public class FaresFactory {

    public Fares getFares(InvoiceService.FarePremium premium){
        if(InvoiceService.FarePremium.NORMAL.equals(premium))
            return new Fares(10.0,1.0,5.0);
        return new Fares(15.0,2.0,20.0);
    }
}
