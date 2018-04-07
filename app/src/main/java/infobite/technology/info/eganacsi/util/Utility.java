package infobite.technology.info.eganacsi.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by kamlesh on 4/7/2018.
 */

public class Utility
{
    public static void toastView(Context ctx,String messgae) {
        Toast.makeText(ctx,messgae,Toast.LENGTH_LONG).show();
    }
}
