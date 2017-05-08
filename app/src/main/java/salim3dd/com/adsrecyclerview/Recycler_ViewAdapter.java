package salim3dd.com.adsrecyclerview;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;

import java.util.List;


public class Recycler_ViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<List_Item> mList;
    private Context context;

    public Recycler_ViewAdapter(List<List_Item> list_Item, Context context) {
        mList = list_Item;
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        switch (viewType) {
            case 1: {
                View v1 = inflater.inflate(R.layout.row_item_main, viewGroup, false);
                viewHolder = new MenuItemViewHolder_main(v1);
                break;
            }
            case 2: {
                View v2 = inflater.inflate(R.layout.list_item_native, viewGroup, false);
                viewHolder = new ViewHolderNative_main(v2);
                break;
            }

        }
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int i) {

        final List_Item model = mList.get(holder.getAdapterPosition());

        switch (holder.getItemViewType()) {
            case 1: {
                MenuItemViewHolder_main menuItemHolder = (MenuItemViewHolder_main) holder;

                String TBooks = model.getTitle();
                menuItemHolder.TV_Title.setText(TBooks);
            }
            break;

            case 2: {
                ///ADS
                break;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    protected class MenuItemViewHolder_main extends RecyclerView.ViewHolder {

        TextView TV_Title;
        MenuItemViewHolder_main(View view) {
            super(view);
            TV_Title = (TextView) view.findViewById(R.id.TV_Title);

        }
    }

    public static class ViewHolderNative_main extends RecyclerView.ViewHolder {
        public NativeExpressAdView adView;

        public ViewHolderNative_main(View view) {
            super(view);
            adView = (NativeExpressAdView) view.findViewById(R.id.adView);
            AdRequest request = new AdRequest.Builder()
                   // .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();
            adView.loadAd(request);
        }
    }

}
