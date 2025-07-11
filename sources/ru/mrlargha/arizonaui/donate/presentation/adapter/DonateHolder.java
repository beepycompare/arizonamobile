package ru.mrlargha.arizonaui.donate.presentation.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.arizonaui.databinding.DonateItemBinding;
import ru.mrlargha.arizonaui.donate.domain.obj.DonateItem;
import ru.mrlargha.arizonaui.donate.presentation.adapter.DonateAdapter;
/* compiled from: DonateHolder.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lru/mrlargha/arizonaui/donate/presentation/adapter/DonateHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/DonateItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/DonateItemBinding;", "loadImageJob", "Lkotlinx/coroutines/Job;", "bind", "", "donateItem", "Lru/mrlargha/arizonaui/donate/domain/obj/DonateItem;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lru/mrlargha/arizonaui/donate/presentation/adapter/DonateAdapter$OnItemClickListener;", "currentItemListener", "Lru/mrlargha/arizonaui/donate/presentation/adapter/DonateAdapter$OnCurrentItemListener;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateHolder extends RecyclerView.ViewHolder {
    private final DonateItemBinding binding;
    private Job loadImageJob;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateHolder(View item) {
        super(item);
        Intrinsics.checkNotNullParameter(item, "item");
        DonateItemBinding bind = DonateItemBinding.bind(item);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
    }

    public final DonateItemBinding getBinding() {
        return this.binding;
    }

    public final void bind(DonateItem donateItem, final DonateAdapter.OnItemClickListener listener, final DonateAdapter.OnCurrentItemListener currentItemListener) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(donateItem, "donateItem");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(currentItemListener, "currentItemListener");
        this.binding.itemTittle.setText(donateItem.getTitle());
        Job job = this.loadImageJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new DonateHolder$bind$1(this, donateItem, null), 3, null);
        this.loadImageJob = launch$default;
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.donate.presentation.adapter.DonateHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateHolder.bind$lambda$0(DonateAdapter.OnItemClickListener.this, this, view);
            }
        });
        this.binding.donateBuyButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.donate.presentation.adapter.DonateHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateHolder.bind$lambda$1(DonateAdapter.OnCurrentItemListener.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0(DonateAdapter.OnItemClickListener onItemClickListener, DonateHolder donateHolder, View view) {
        onItemClickListener.onItemClick(donateHolder.getBindingAdapterPosition(), donateHolder.binding);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1(DonateAdapter.OnCurrentItemListener onCurrentItemListener, DonateHolder donateHolder, View view) {
        onCurrentItemListener.onCurrentItemClick(donateHolder.getBindingAdapterPosition());
    }
}
