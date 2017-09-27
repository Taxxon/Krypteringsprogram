/**
 * Created by Emil Käck on 2017-09-20.
 */
public class BitWiseCoord {

    short cordinate = 0;

    public BitWiseCoord(int x, int y){
        x = x << 8;
        cordinate = (short)(x | y);
    }

    public void setHigh(int x){
        x = x << 8;
        int y = 255;
        cordinate = (short)(cordinate | x);
        cordinate = (short)(cordinate & y);
    }

    public void setLow(int y){
        int x = 255;
        x = x << 8;
        cordinate = (short)(cordinate & x);
        cordinate = (short)(cordinate | y);
    }

    public void getHigh(){
        int x = 255;
        x = x << 8;
        short high = (short)(x & cordinate);
        high = (short)(high >>> 8);
        System.out.println(high);
    }

    public void getLow(){
        int y = 255;
        short high = (short)(y & cordinate);
        System.out.println(high);
    }
}
