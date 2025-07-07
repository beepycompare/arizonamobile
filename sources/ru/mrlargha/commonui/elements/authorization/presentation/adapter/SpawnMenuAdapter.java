package ru.mrlargha.commonui.elements.authorization.presentation.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.authorization.domain.spawn.SpawnData;
import ru.mrlargha.commonui.utils.ConverterKt;
/* compiled from: SpawnMenuAdapter.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\u0014\u0010\u0019\u001a\u00020\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bJ\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/adapter/SpawnMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/authorization/presentation/adapter/SpawnMenuViewHolder;", "targetActivity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "spawnList", "Ljava/util/ArrayList;", "Lru/mrlargha/commonui/elements/authorization/domain/spawn/SpawnData;", "Lkotlin/collections/ArrayList;", "red", "", "grey", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lru/mrlargha/commonui/elements/authorization/presentation/adapter/SpawnMenuAdapter$SelectedSpawnListener;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "addSpawns", "spawns", "", "selectedSpawnListener", "SelectedSpawnListener", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpawnMenuAdapter extends RecyclerView.Adapter<SpawnMenuViewHolder> {
    private final int grey;
    private SelectedSpawnListener listener;
    private final int red;
    private final ArrayList<SpawnData> spawnList;
    private final Activity targetActivity;

    /* compiled from: SpawnMenuAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/adapter/SpawnMenuAdapter$SelectedSpawnListener;", "", "selectedSpawnListener", "", "position", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface SelectedSpawnListener {
        void selectedSpawnListener(int i);
    }

    public SpawnMenuAdapter(Activity targetActivity) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.targetActivity = targetActivity;
        this.spawnList = new ArrayList<>();
        this.red = Color.parseColor("#FF2323");
        this.grey = Color.parseColor("#7E7E7E");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SpawnMenuViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.spawner_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new SpawnMenuViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SpawnMenuViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Drawable mutate = holder.getSpawnItem().spawnItem.getBackground().mutate();
        Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) mutate;
        holder.getSpawnItem().spawnItemTitle.setText(this.spawnList.get(i).getSpawn());
        if (this.spawnList.get(i).getClicked()) {
            holder.getSpawnItem().spawnItemIcon.setColorFilter(this.red);
            gradientDrawable.setStroke(ConverterKt.dpToPx(5, this.targetActivity), this.red);
        } else {
            holder.getSpawnItem().spawnItemIcon.setColorFilter(this.grey);
            gradientDrawable.setStroke(ConverterKt.dpToPx(5, this.targetActivity), 0);
        }
        holder.getSpawnItem().spawnItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.adapter.SpawnMenuAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpawnMenuAdapter.onBindViewHolder$lambda$3$lambda$2(SpawnMenuAdapter.this, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3$lambda$2(SpawnMenuAdapter spawnMenuAdapter, int i, View view) {
        SelectedSpawnListener selectedSpawnListener = spawnMenuAdapter.listener;
        if (selectedSpawnListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            selectedSpawnListener = null;
        }
        selectedSpawnListener.selectedSpawnListener(i);
        ArrayList<SpawnData> arrayList = new ArrayList();
        for (Object obj : spawnMenuAdapter.spawnList) {
            if (((SpawnData) obj).getClicked()) {
                arrayList.add(obj);
            }
        }
        for (SpawnData spawnData : arrayList) {
            spawnData.setClicked(false);
            spawnMenuAdapter.notifyItemChanged(spawnMenuAdapter.spawnList.indexOf(spawnData));
        }
        if (spawnMenuAdapter.spawnList.size() > i) {
            spawnMenuAdapter.spawnList.get(i).setClicked(true);
            spawnMenuAdapter.notifyItemChanged(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.spawnList.size();
    }

    public final void addSpawns(List<SpawnData> spawns) {
        Intrinsics.checkNotNullParameter(spawns, "spawns");
        this.spawnList.clear();
        this.spawnList.addAll(spawns);
        notifyDataSetChanged();
    }

    public final void selectedSpawnListener(SelectedSpawnListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }
}
