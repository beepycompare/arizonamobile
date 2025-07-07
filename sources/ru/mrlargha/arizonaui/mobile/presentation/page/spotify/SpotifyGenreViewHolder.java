package ru.mrlargha.arizonaui.mobile.presentation.page.spotify;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.databinding.SpotifyGenreItemBinding;
/* compiled from: SpotifyGenreAdapter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/spotify/SpotifyGenreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "genreBinding", "Lru/mrlargha/arizonaui/databinding/SpotifyGenreItemBinding;", "getGenreBinding", "()Lru/mrlargha/arizonaui/databinding/SpotifyGenreItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpotifyGenreViewHolder extends RecyclerView.ViewHolder {
    private final SpotifyGenreItemBinding genreBinding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpotifyGenreViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        SpotifyGenreItemBinding bind = SpotifyGenreItemBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.genreBinding = bind;
    }

    public final SpotifyGenreItemBinding getGenreBinding() {
        return this.genreBinding;
    }
}
