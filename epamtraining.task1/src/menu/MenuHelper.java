package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by piatr on 18.07.18.
 */
public class MenuHelper {

    public static String getIn ()throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return in.readLine();
    }
}
