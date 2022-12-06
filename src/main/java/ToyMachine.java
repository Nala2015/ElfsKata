public class ToyMachine
{
    private MrsClaus mrsClaus;

    public ToyMachine(MrsClaus mrsClaus){
        this.mrsClaus = mrsClaus;
    }

    public void givePresentToMrsClaus(Present present){
        mrsClaus.receivePresent(present);
    }
}
