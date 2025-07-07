package ru.mrlargha.arizonaui.mobile.presentation.page.spotify;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.SpotifyTracklistItemBinding;
import ru.mrlargha.arizonaui.mobile.domain.obj.ChangeArtistNameRadioRequest;
import ru.mrlargha.arizonaui.mobile.presentation.page.spotify.api.obj.SpotifyTrackResponse;
/* compiled from: SpotifyTrackListAdapter.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002,-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J\u0014\u0010\u001d\u001a\u00020\b*\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u001c\u0010 \u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0!2\u0006\u0010\"\u001a\u00020\u0013J\u0014\u0010#\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110!J\u000e\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0011J\u0014\u0010&\u001a\u00020\b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0!J\u0006\u0010)\u001a\u00020\bJ\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000e0!J\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00110\rj\b\u0012\u0004\u0012\u00020\u0011`\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00110\rj\b\u0012\u0004\u0012\u00020\u0011`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006."}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/SpotifyTrackListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/SpotifyTrackListViewHolder;", "<init>", "()V", "onPlayTrackClickListener", "Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/SpotifyTrackListAdapter$OnPlayTrackClickListener;", "setOnPlayTrackClickListener", "", "onFavouriteClickListener", "Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/SpotifyTrackListAdapter$OnFavouriteClickListener;", "setOnFavouriteClickListener", "trackList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/api/obj/SpotifyTrackResponse;", "Lkotlin/collections/ArrayList;", "favouriteList", "", "currentGenre", "", "currentTrackId", "Ljava/lang/Integer;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "changePlayingState", "Lru/mrlargha/arizonaui/databinding/SpotifyTracklistItemBinding;", "getItemCount", "addTrackList", "", "genre", "addFavourites", "removeFromFavourite", "favouriteId", "changeArtistNameRadio", "changeArtistNameRadioRequest", "Lru/mrlargha/arizonaui/mobile/domain/obj/ChangeArtistNameRadioRequest;", "clearTrackList", "getCurrentTrackList", "getFavourites", "OnPlayTrackClickListener", "OnFavouriteClickListener", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpotifyTrackListAdapter extends RecyclerView.Adapter<SpotifyTrackListViewHolder> {
    private Integer currentTrackId;
    private OnFavouriteClickListener onFavouriteClickListener;
    private OnPlayTrackClickListener onPlayTrackClickListener;
    private final ArrayList<SpotifyTrackResponse> trackList = new ArrayList<>();
    private final ArrayList<Integer> favouriteList = new ArrayList<>();
    private String currentGenre = "";

    /* compiled from: SpotifyTrackListAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/SpotifyTrackListAdapter$OnFavouriteClickListener;", "", "callback", "", "trackId", "", "isFavouriteExist", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnFavouriteClickListener {
        void callback(int i, boolean z);
    }

    /* compiled from: SpotifyTrackListAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/SpotifyTrackListAdapter$OnPlayTrackClickListener;", "", "callback", "", "trackId", "", "isTrackChanged", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnPlayTrackClickListener {
        void callback(int i, boolean z);
    }

    public final void setOnPlayTrackClickListener(OnPlayTrackClickListener onPlayTrackClickListener) {
        Intrinsics.checkNotNullParameter(onPlayTrackClickListener, "onPlayTrackClickListener");
        this.onPlayTrackClickListener = onPlayTrackClickListener;
    }

    public final void setOnFavouriteClickListener(OnFavouriteClickListener onFavouriteClickListener) {
        Intrinsics.checkNotNullParameter(onFavouriteClickListener, "onFavouriteClickListener");
        this.onFavouriteClickListener = onFavouriteClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SpotifyTrackListViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.spotify_tracklist_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new SpotifyTrackListViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SpotifyTrackListViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        SpotifyTrackResponse spotifyTrackResponse = this.trackList.get(i);
        Intrinsics.checkNotNullExpressionValue(spotifyTrackResponse, "get(...)");
        final SpotifyTrackResponse spotifyTrackResponse2 = spotifyTrackResponse;
        final SpotifyTracklistItemBinding binding = holder.getBinding();
        binding.spotifyFavourite.setImageResource(R.drawable.ic_favorites_disabled);
        binding.spotifySingerName.setText(this.trackList.get(i).getArtistName());
        binding.spotifySongName.setText(this.trackList.get(i).getSongName());
        binding.spotifySongTime.setText(this.trackList.get(i).getTime());
        if (Intrinsics.areEqual(this.currentGenre, "radio")) {
            binding.spotifySongTime.setVisibility(8);
            binding.spotifyFavourite.setVisibility(8);
        } else {
            binding.spotifySongTime.setVisibility(0);
            binding.spotifyFavourite.setVisibility(0);
        }
        Integer num = this.currentTrackId;
        int id = this.trackList.get(i).getId();
        if (num != null && num.intValue() == id) {
            if (SpotifyPage.Companion.isTrackPlaying()) {
                binding.spotifyPlay.setImageResource(R.drawable.spotify_play_off);
            } else {
                binding.spotifyPlay.setImageResource(R.drawable.spotify_play_on);
            }
        } else {
            binding.spotifyPlay.setImageResource(R.drawable.spotify_play_on);
        }
        binding.spotifyTracklistItem.getBackground().setTint(Color.parseColor("#70FFFFFF"));
        for (Number number : this.favouriteList) {
            int intValue = number.intValue();
            if (spotifyTrackResponse2.getId() == intValue) {
                System.out.println((Object) ("init true " + spotifyTrackResponse2.getId() + " == " + intValue));
                binding.spotifyFavourite.setImageResource(R.drawable.ic_favorites_enabled_white);
            }
        }
        binding.spotifyTracklistItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyTrackListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpotifyTrackListAdapter.onBindViewHolder$lambda$7$lambda$3(SpotifyTrackListAdapter.this, spotifyTrackResponse2, binding, i, view);
            }
        });
        binding.spotifyPlay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyTrackListAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpotifyTrackListAdapter.onBindViewHolder$lambda$7$lambda$4(SpotifyTrackResponse.this, this, binding, i, view);
            }
        });
        binding.spotifyFavourite.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyTrackListAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpotifyTrackListAdapter.onBindViewHolder$lambda$7$lambda$6(SpotifyTrackListAdapter.this, spotifyTrackResponse2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$7$lambda$3(SpotifyTrackListAdapter spotifyTrackListAdapter, SpotifyTrackResponse spotifyTrackResponse, SpotifyTracklistItemBinding spotifyTracklistItemBinding, int i, View view) {
        view.getBackground().setTint(Color.parseColor("#FFFFFF"));
        ArrayList<SpotifyTrackResponse> arrayList = new ArrayList();
        for (Object obj : spotifyTrackListAdapter.trackList) {
            if (((SpotifyTrackResponse) obj).isTrackActive()) {
                arrayList.add(obj);
            }
        }
        for (SpotifyTrackResponse spotifyTrackResponse2 : arrayList) {
            spotifyTrackListAdapter.notifyItemChanged(spotifyTrackListAdapter.trackList.indexOf(spotifyTrackResponse2));
        }
        spotifyTrackResponse.setTrackActive(!spotifyTrackResponse.isTrackActive());
        spotifyTrackListAdapter.changePlayingState(spotifyTracklistItemBinding, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$7$lambda$4(SpotifyTrackResponse spotifyTrackResponse, SpotifyTrackListAdapter spotifyTrackListAdapter, SpotifyTracklistItemBinding spotifyTracklistItemBinding, int i, View view) {
        spotifyTrackResponse.setTrackActive(!spotifyTrackResponse.isTrackActive());
        spotifyTrackListAdapter.changePlayingState(spotifyTracklistItemBinding, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$7$lambda$6(SpotifyTrackListAdapter spotifyTrackListAdapter, SpotifyTrackResponse spotifyTrackResponse, View view) {
        try {
            ArrayList<Integer> arrayList = spotifyTrackListAdapter.favouriteList;
            boolean z = false;
            if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                Iterator<T> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((Number) it.next()).intValue() == spotifyTrackResponse.getId()) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                spotifyTrackListAdapter.removeFromFavourite(spotifyTrackResponse.getId());
            } else {
                spotifyTrackListAdapter.addFavourites(CollectionsKt.listOf(Integer.valueOf(spotifyTrackResponse.getId())));
            }
            OnFavouriteClickListener onFavouriteClickListener = spotifyTrackListAdapter.onFavouriteClickListener;
            if (onFavouriteClickListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onFavouriteClickListener");
                onFavouriteClickListener = null;
            }
            onFavouriteClickListener.callback(spotifyTrackResponse.getId(), z);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Spotify", "Track ID incorrect | spotifyFavourite");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006b A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:2:0x0000, B:11:0x0030, B:12:0x0042, B:14:0x0048, B:17:0x0058, B:21:0x0060, B:22:0x0067, B:24:0x006b, B:26:0x0072, B:33:0x0098, B:29:0x008f, B:5:0x0012, B:7:0x0018, B:9:0x0020, B:10:0x0028), top: B:38:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void changePlayingState(SpotifyTracklistItemBinding spotifyTracklistItemBinding, int i) {
        OnPlayTrackClickListener onPlayTrackClickListener;
        Integer num;
        boolean z;
        Object obj;
        try {
            Integer num2 = this.currentTrackId;
            int id = this.trackList.get(i).getId();
            OnPlayTrackClickListener onPlayTrackClickListener2 = null;
            if (num2 != null && num2.intValue() == id) {
                if (SpotifyPage.Companion.isTrackPlaying()) {
                    spotifyTracklistItemBinding.spotifyPlay.setImageResource(R.drawable.spotify_play_on);
                } else {
                    spotifyTracklistItemBinding.spotifyPlay.setImageResource(R.drawable.spotify_play_off);
                }
                onPlayTrackClickListener = this.onPlayTrackClickListener;
                if (onPlayTrackClickListener != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("onPlayTrackClickListener");
                } else {
                    onPlayTrackClickListener2 = onPlayTrackClickListener;
                }
                int id2 = this.trackList.get(i).getId();
                num = this.currentTrackId;
                int id3 = this.trackList.get(i).getId();
                if (num != null && num.intValue() == id3) {
                    z = false;
                    onPlayTrackClickListener2.callback(id2, z);
                    this.currentTrackId = Integer.valueOf(this.trackList.get(i).getId());
                }
                z = true;
                onPlayTrackClickListener2.callback(id2, z);
                this.currentTrackId = Integer.valueOf(this.trackList.get(i).getId());
            }
            spotifyTracklistItemBinding.spotifyPlay.setImageResource(R.drawable.spotify_play_off);
            ArrayList<SpotifyTrackResponse> arrayList = this.trackList;
            ArrayList<SpotifyTrackResponse> arrayList2 = arrayList;
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                int id4 = ((SpotifyTrackResponse) obj).getId();
                Integer num3 = this.currentTrackId;
                if (num3 != null && id4 == num3.intValue()) {
                    break;
                }
            }
            notifyItemChanged(CollectionsKt.indexOf((List<? extends Object>) arrayList2, obj));
            onPlayTrackClickListener = this.onPlayTrackClickListener;
            if (onPlayTrackClickListener != null) {
            }
            int id22 = this.trackList.get(i).getId();
            num = this.currentTrackId;
            int id32 = this.trackList.get(i).getId();
            if (num != null) {
                z = false;
                onPlayTrackClickListener2.callback(id22, z);
                this.currentTrackId = Integer.valueOf(this.trackList.get(i).getId());
            }
            z = true;
            onPlayTrackClickListener2.callback(id22, z);
            this.currentTrackId = Integer.valueOf(this.trackList.get(i).getId());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Spotify", "Track ID incorrect");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.trackList.size();
    }

    public final void addTrackList(List<SpotifyTrackResponse> trackList, String genre) {
        Intrinsics.checkNotNullParameter(trackList, "trackList");
        Intrinsics.checkNotNullParameter(genre, "genre");
        this.currentGenre = genre;
        int size = this.trackList.size();
        this.trackList.addAll(trackList);
        notifyItemRangeInserted(size, trackList.size());
    }

    public final void addFavourites(List<Integer> favouriteList) {
        Intrinsics.checkNotNullParameter(favouriteList, "favouriteList");
        this.favouriteList.addAll(favouriteList);
        int i = 0;
        for (Object obj : this.trackList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SpotifyTrackResponse spotifyTrackResponse = (SpotifyTrackResponse) obj;
            for (Number number : favouriteList) {
                if (spotifyTrackResponse.getId() == number.intValue()) {
                    notifyItemChanged(i);
                }
            }
            i = i2;
        }
    }

    public final void removeFromFavourite(int i) {
        this.favouriteList.remove(Integer.valueOf(i));
        int i2 = 0;
        for (Object obj : this.trackList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (i == ((SpotifyTrackResponse) obj).getId()) {
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }

    public final void changeArtistNameRadio(List<ChangeArtistNameRadioRequest> changeArtistNameRadioRequest) {
        Intrinsics.checkNotNullParameter(changeArtistNameRadioRequest, "changeArtistNameRadioRequest");
        int i = 0;
        for (Object obj : this.trackList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SpotifyTrackResponse spotifyTrackResponse = (SpotifyTrackResponse) obj;
            for (ChangeArtistNameRadioRequest changeArtistNameRadioRequest2 : changeArtistNameRadioRequest) {
                if (spotifyTrackResponse.getId() == changeArtistNameRadioRequest2.getId()) {
                    int id = spotifyTrackResponse.getId();
                    System.out.println((Object) ("track.id = " + id + " :  req.id = " + changeArtistNameRadioRequest2.getId()));
                    spotifyTrackResponse.setArtistName(changeArtistNameRadioRequest2.getArtistName());
                    notifyItemChanged(i);
                }
            }
            i = i2;
        }
    }

    public final void clearTrackList() {
        this.trackList.clear();
        notifyDataSetChanged();
    }

    public final List<SpotifyTrackResponse> getCurrentTrackList() {
        return this.trackList;
    }

    public final ArrayList<Integer> getFavourites() {
        return this.favouriteList;
    }
}
