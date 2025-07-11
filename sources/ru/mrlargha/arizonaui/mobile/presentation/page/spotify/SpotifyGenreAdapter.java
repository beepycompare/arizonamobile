package ru.mrlargha.arizonaui.mobile.presentation.page.spotify;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.SpotifyGenreItemBinding;
/* compiled from: SpotifyGenreAdapter.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/SpotifyGenreAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/SpotifyGenreViewHolder;", "<init>", "()V", "onGenreClickListener", "Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/SpotifyGenreAdapter$OnGenreClickListener;", "setOnGenreClickListener", "", "context", "Landroid/content/Context;", "listGenre", "", "Lkotlin/Pair;", "", "listImage", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "OnGenreClickListener", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpotifyGenreAdapter extends RecyclerView.Adapter<SpotifyGenreViewHolder> {
    private Context context;
    private final List<Pair<String, String>> listGenre = CollectionsKt.listOf((Object[]) new Pair[]{new Pair("top", "Топ-100"), new Pair("pop", "Поп"), new Pair("rock", "Рок"), new Pair("indie", "Инди"), new Pair("jazz", "Джаз/Кантри"), new Pair("rnb", "RnB"), new Pair("chanson", "Шансон"), new Pair("rap", "Рэп и хип-хоп"), new Pair("electronic", "Электроника"), new Pair("classic", "Классическая"), new Pair("delorenzy", "Делорензи"), new Pair("phonk", "Phonk"), new Pair("nfs", "NFS"), new Pair("radio", "Радио"), new Pair("favourites", "Избранное")});
    private final List<Integer> listImage = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.horizontal_refresh), Integer.valueOf(R.drawable.spotify_pop_ic), Integer.valueOf(R.drawable.spotify_rock_icon), Integer.valueOf(R.drawable.spotify_indi_icon), Integer.valueOf(R.drawable.spotify_jazz_icon), Integer.valueOf(R.drawable.spotify_rnb_icon), Integer.valueOf(R.drawable.spotify_chanson_icon), Integer.valueOf(R.drawable.spotify_rap_icon), Integer.valueOf(R.drawable.spotify_electronic_icon), Integer.valueOf(R.drawable.spotify_classic_icon), Integer.valueOf(R.drawable.spotify_delorenzy_icon), Integer.valueOf(R.drawable.spotify_phonk_icon), Integer.valueOf(R.drawable.spotify_nfs_icon), Integer.valueOf(R.drawable.spotify_radio_icon), Integer.valueOf(R.drawable.spotify_favourites_icon)});
    private OnGenreClickListener onGenreClickListener;

    /* compiled from: SpotifyGenreAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/SpotifyGenreAdapter$OnGenreClickListener;", "", "callback", "", "genre", "", "position", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnGenreClickListener {
        void callback(String str, int i);
    }

    public final void setOnGenreClickListener(OnGenreClickListener onGenreClickListener) {
        Intrinsics.checkNotNullParameter(onGenreClickListener, "onGenreClickListener");
        this.onGenreClickListener = onGenreClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SpotifyGenreViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.context = context;
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.spotify_genre_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new SpotifyGenreViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SpotifyGenreViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        SpotifyGenreItemBinding genreBinding = holder.getGenreBinding();
        genreBinding.spotifyGenreTitle.setText(this.listGenre.get(i).getSecond());
        AppCompatImageView appCompatImageView = genreBinding.spotifyGenreIcon;
        Context context = this.context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        appCompatImageView.setImageDrawable(ContextCompat.getDrawable(context, this.listImage.get(i).intValue()));
        if (Intrinsics.areEqual(this.listGenre.get(i).getSecond(), "Избранное")) {
            genreBinding.spotifyGenreTitle.setTextColor(Color.parseColor("#FFCB5A"));
            genreBinding.spotifyGenreContainer.getBackground().setTint(Color.parseColor("#FFCB5A"));
            genreBinding.spotifyGenreIcon.setColorFilter(Color.parseColor("#FFCB5A"));
        }
        genreBinding.spotifyGenreContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.page.spotify.SpotifyGenreAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpotifyGenreAdapter.onBindViewHolder$lambda$1$lambda$0(SpotifyGenreAdapter.this, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(SpotifyGenreAdapter spotifyGenreAdapter, int i, View view) {
        OnGenreClickListener onGenreClickListener = spotifyGenreAdapter.onGenreClickListener;
        if (onGenreClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onGenreClickListener");
            onGenreClickListener = null;
        }
        onGenreClickListener.callback(spotifyGenreAdapter.listGenre.get(i).getFirst(), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.listGenre.size();
    }
}
