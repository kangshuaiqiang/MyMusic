package test.bwie.com.mymusic.View.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import test.bwie.com.mymusic.Model.Bean.MusicList;
import test.bwie.com.mymusic.Model.Bean.MusicListChild;
import test.bwie.com.mymusic.Presenter.Persen.HomePersent;
import test.bwie.com.mymusic.Presenter.interfaces.GetBeanP_V;
import test.bwie.com.mymusic.R;
import test.bwie.com.mymusic.View.Activity.PlayListActivity;

/**
 * Created by 黑白 on 2017/9/29.
 */

public class OlineRecyclerAdapter extends RecyclerView.Adapter {

    private List<MusicListChild> musicListChildren;
    private Context context;
    private HomePersent homePersent;
    private final int TYPE1 = 0;
    private final int TYPE2 = 1;

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public OlineRecyclerAdapter(List<MusicListChild> musicListChildren, Context context, HomePersent homePersent) {
        this.musicListChildren = musicListChildren;
        this.context = context;
        this.homePersent = homePersent;
    }

    @Override
    public int getItemViewType(int position) {
        String type = musicListChildren.get(position).getType();
        if (type.equals("#")) {
            return TYPE1;
        } else {
            return TYPE2;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int itemViewType = getItemViewType(viewType);
        if (itemViewType == 0) {
            View view = View.inflate(context, R.layout.online_item_1, null);
            return new Holder1(view);
        } else {
            View view = View.inflate(context, R.layout.online_item_2, null);
            return new Holder2(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0) {
            if (holder instanceof Holder1) {
                Holder1 holder1 = (Holder1) holder;
                holder1.textView.setText(musicListChildren.get(position).getListName());
            }
        } else {
            if (holder instanceof Holder2) {
                final Holder2 holder2 = (Holder2) holder;
                holder2.linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String type = musicListChildren.get(position).getType();
                        Toast.makeText(context, "" + type, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, PlayListActivity.class);
                        intent.putExtra("type", type);
                        context.startActivity(intent);
                    }
                });
                homePersent.initDatte(musicListChildren.get(position).getType());
                homePersent.initGetBeanP_V(new GetBeanP_V() {
                    @Override
                    public void Succeed(Object o) {
                        MusicList musicList = (MusicList) o;
                        List<MusicList.SongListBean> song_list = musicList.getSong_list();
//                        holder2.imageView;
                        int size = song_list.size();
                        switch (size) {
                            case 1:
                                Glide.with(context).load(musicList.getBillboard().getPic_s192()).into(holder2.imageView);
                                holder2.music1.setText(song_list.get(0).getAlbum_title());
                                holder2.music2.setVisibility(View.GONE);
                                holder2.music3.setVisibility(View.GONE);
                                break;
                            case 2:
                                Glide.with(context).load(musicList.getBillboard().getPic_s192()).into(holder2.imageView);
                                holder2.music1.setText(song_list.get(0).getAlbum_title());
                                holder2.music2.setText(song_list.get(1).getAlbum_title());
                                holder2.music3.setVisibility(View.GONE);
                                break;
                            case 3:
                                Glide.with(context).load(musicList.getBillboard().getPic_s192()).into(holder2.imageView);
                                holder2.music1.setText(song_list.get(0).getAlbum_title());
                                holder2.music2.setText(song_list.get(1).getAlbum_title());
                                holder2.music3.setText(song_list.get(2).getAlbum_title());
                                break;
                            default:
                                Glide.with(context).load(musicList.getBillboard().getPic_s192()).into(holder2.imageView);
                                holder2.music1.setText(song_list.get(0).getAlbum_title());
                                holder2.music2.setText(song_list.get(1).getAlbum_title());
                                holder2.music3.setText(song_list.get(2).getAlbum_title());
                                break;
                        }

                    }

                    @Override
                    public void Erroe(int errorCode, String errorMessger) {

                    }
                });

            }
        }


    }

    @Override
    public int getItemCount() {
        return musicListChildren.size();
    }


    class Holder1 extends RecyclerView.ViewHolder {
        TextView textView;

        public Holder1(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item1_textView);
        }
    }

    class Holder2 extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView music1;
        TextView music2;
        TextView music3;
        LinearLayout linearLayout;

        public Holder2(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item2_imageView);
            music1 = itemView.findViewById(R.id.music1);
            music2 = itemView.findViewById(R.id.music2);
            music3 = itemView.findViewById(R.id.music3);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
