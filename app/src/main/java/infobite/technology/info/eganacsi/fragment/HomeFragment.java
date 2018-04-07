package infobite.technology.info.eganacsi.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import infobite.technology.info.eganacsi.R;

/**
 * Created by kamlesh on 4/4/2018.
 */
@SuppressLint("ValidFragment")
public class HomeFragment extends Fragment {

    View view;
    Context ctx;

    @SuppressLint("ValidFragment")
    public HomeFragment(Context ctx) {
        this.ctx = ctx;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,null);
        return view;
    }

}
