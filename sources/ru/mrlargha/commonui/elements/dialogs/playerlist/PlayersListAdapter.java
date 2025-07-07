package ru.mrlargha.commonui.elements.dialogs.playerlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
/* compiled from: PlayersListAdapter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/playerlist/PlayersListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/dialogs/playerlist/Player;", "Lru/mrlargha/commonui/elements/dialogs/playerlist/PlayersListAdapter$PlayerViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "PlayerViewHolder", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PlayersListAdapter extends ListAdapter<Player, PlayerViewHolder> {
    public PlayersListAdapter() {
        super(new PlayerDiffCallback());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PlayerViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return PlayerViewHolder.Companion.from(parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PlayerViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Player item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item);
    }

    /* compiled from: PlayersListAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/playerlist/PlayersListAdapter$PlayerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "idView", "Landroid/widget/TextView;", "nickView", "levelView", "pingView", "bind", "", "item", "Lru/mrlargha/commonui/elements/dialogs/playerlist/Player;", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PlayerViewHolder extends RecyclerView.ViewHolder {
        public static final Companion Companion = new Companion(null);
        private final TextView idView;
        private final TextView levelView;
        private final TextView nickView;
        private final TextView pingView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlayerViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.player_id);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.idView = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.player_nickname);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.nickView = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.player_level);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.levelView = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.player_ping);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.pingView = (TextView) findViewById4;
        }

        public final void bind(Player item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.idView.setText(String.valueOf(item.getId()));
            this.nickView.setText(item.getName());
            this.levelView.setText(String.valueOf(item.getLevel()));
            this.pingView.setText(String.valueOf(item.getPing()));
            this.idView.setTextColor(item.getColor());
            this.nickView.setTextColor(item.getColor());
            this.levelView.setTextColor(item.getColor());
            this.pingView.setTextColor(item.getColor());
        }

        /* compiled from: PlayersListAdapter.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/playerlist/PlayersListAdapter$PlayerViewHolder$Companion;", "", "<init>", "()V", "from", "Lru/mrlargha/commonui/elements/dialogs/playerlist/PlayersListAdapter$PlayerViewHolder;", "parent", "Landroid/view/ViewGroup;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final PlayerViewHolder from(ViewGroup parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_view, parent, false);
                Intrinsics.checkNotNull(inflate);
                return new PlayerViewHolder(inflate);
            }
        }
    }
}
