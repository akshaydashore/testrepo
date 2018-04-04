package infobite.technology.info.eganacsi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import infobite.technology.info.eganacsi.R;
import infobite.technology.info.eganacsi.model.Navigation;

/**
 * Created by kamlesh on 2/17/2018.
 */
public class NavigationAdapter extends BaseAdapter {

    Context ctx;
    ArrayList<Navigation> nav_list;

    public NavigationAdapter(Context ctx, ArrayList<Navigation> nav_list) {
        this.ctx = ctx;
        this.nav_list = nav_list;
    }

    @Override
    public int getCount() {
        return nav_list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.adp_navigation, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.iv_nav_image);
        TextView name_tv = (TextView) view.findViewById(R.id.tv_nav_name);

        String name = nav_list.get(8).getName();
        if (position==8){

            imageView.setVisibility(View.GONE);
            name_tv.setTextSize(15);
            name_tv.setText(nav_list.get(position).getName());
        }else {

            name_tv.setText(nav_list.get(position).getName());
        }
        return view;
    }
}