package ru.mrlargha.commonui.elements.dice;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.DiceGamerItemBinding;
/* compiled from: DicePlayerAdapter.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/dice/DicePlayerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/dice/DicePlayerAdapter$DiceGamerViewHolder;", "<init>", "()V", "gamers", "", "Lru/mrlargha/commonui/elements/dice/DicePlayerData;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "addGamer", "gamer", "sortGamers", "updateGamer", "Lru/mrlargha/commonui/elements/dice/DiceUpdatePlayerData;", "deleteGamer", "Lru/mrlargha/commonui/elements/dice/DiceDeletePlayerData;", "removeAllPlayers", "DiceGamerViewHolder", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DicePlayerAdapter extends RecyclerView.Adapter<DiceGamerViewHolder> {
    private final List<DicePlayerData> gamers = new ArrayList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DiceGamerViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.dice_gamer_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new DiceGamerViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.gamers.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DiceGamerViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        DicePlayerData dicePlayerData = this.gamers.get(i);
        DiceGamerItemBinding binding = holder.getBinding();
        binding.gamerNickname.setText(dicePlayerData.getName() + StringUtils.PROCESS_POSTFIX_DELIMITER);
        if (dicePlayerData.isCurrent() == 0) {
            binding.gamerNickname.setTextColor(Color.parseColor("#70FFFFFF"));
        }
        if (dicePlayerData.getStatus() != null) {
            if (Intrinsics.areEqual("0", dicePlayerData.getStatus()) || Intrinsics.areEqual("1", dicePlayerData.getStatus())) {
                binding.gamerIcon.setVisibility(4);
                binding.diceScoreBg.setVisibility(4);
                return;
            }
            binding.gamerIcon.setVisibility(0);
            binding.diceScoreBg.setVisibility(0);
            if (Intrinsics.areEqual(ExifInterface.GPS_MEASUREMENT_2D, dicePlayerData.getStatus())) {
                binding.gamerIcon.setImageResource(R.drawable.dice_host_ic);
            } else if (Intrinsics.areEqual(ExifInterface.GPS_MEASUREMENT_3D, dicePlayerData.getStatus())) {
                binding.gamerIcon.setImageResource(R.drawable.dice_gogame);
            } else if (Intrinsics.areEqual("4", dicePlayerData.getStatus())) {
                binding.gamerIcon.setImageResource(R.drawable.dice_complete);
            }
            if (dicePlayerData.getScore() == 0) {
                binding.diceScoreBg.setVisibility(4);
                return;
            }
            binding.diceScoreBg.setVisibility(0);
            binding.diceScore.setText(String.valueOf(dicePlayerData.getScore()));
        }
    }

    public final void addGamer(DicePlayerData gamer) {
        Intrinsics.checkNotNullParameter(gamer, "gamer");
        this.gamers.add(gamer);
        notifyDataSetChanged();
    }

    public final void sortGamers() {
        List sortedWith = CollectionsKt.sortedWith(this.gamers, new Comparator() { // from class: ru.mrlargha.commonui.elements.dice.DicePlayerAdapter$sortGamers$$inlined$sortedBy$1
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
                if (r10.equals("4") == false) goto L23;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0044  */
            @Override // java.util.Comparator
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final int compare(T t, T t2) {
                int i;
                String status;
                String status2 = ((DicePlayerData) t).getStatus();
                int i2 = 2;
                if (status2 != null) {
                    switch (status2.hashCode()) {
                        case 50:
                            if (status2.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                                i = 0;
                                break;
                            }
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                            if (status2.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                                i = 1;
                                break;
                            }
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                            if (status2.equals("4")) {
                                i = 2;
                                break;
                            }
                            break;
                    }
                    Integer valueOf = Integer.valueOf(i);
                    status = ((DicePlayerData) t2).getStatus();
                    if (status != null) {
                        switch (status.hashCode()) {
                            case 50:
                                if (status.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                                    i2 = 0;
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                if (status.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                                    i2 = 1;
                                    break;
                                }
                                break;
                        }
                        return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i2));
                    }
                    i2 = 3;
                    return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i2));
                }
                i = 3;
                Integer valueOf2 = Integer.valueOf(i);
                status = ((DicePlayerData) t2).getStatus();
                if (status != null) {
                }
                i2 = 3;
                return ComparisonsKt.compareValues(valueOf2, Integer.valueOf(i2));
            }
        });
        this.gamers.clear();
        this.gamers.addAll(sortedWith);
        notifyDataSetChanged();
    }

    public final void updateGamer(DiceUpdatePlayerData gamer) {
        Intrinsics.checkNotNullParameter(gamer, "gamer");
        for (DicePlayerData dicePlayerData : this.gamers) {
            if (dicePlayerData.getId() == gamer.getId()) {
                dicePlayerData.setScore(gamer.getScore());
                if (gamer.getStatus() != null) {
                    dicePlayerData.setStatus(gamer.getStatus());
                }
                notifyDataSetChanged();
                return;
            }
        }
    }

    public final void deleteGamer(DiceDeletePlayerData gamer) {
        Intrinsics.checkNotNullParameter(gamer, "gamer");
        ListIterator<DicePlayerData> listIterator = this.gamers.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().getId() == gamer.getId()) {
                listIterator.remove();
                notifyDataSetChanged();
                return;
            }
        }
    }

    public final void removeAllPlayers() {
        this.gamers.clear();
        notifyDataSetChanged();
    }

    /* compiled from: DicePlayerAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/dice/DicePlayerAdapter$DiceGamerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/commonui/databinding/DiceGamerItemBinding;", "getBinding", "()Lru/mrlargha/commonui/databinding/DiceGamerItemBinding;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DiceGamerViewHolder extends RecyclerView.ViewHolder {
        private final DiceGamerItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DiceGamerViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            DiceGamerItemBinding bind = DiceGamerItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final DiceGamerItemBinding getBinding() {
            return this.binding;
        }
    }
}
