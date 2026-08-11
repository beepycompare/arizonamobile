package ru.mrlargha.feature.battlepassWinter2025;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.battlepassWinter2025.data.CommonTaskReward;
import ru.mrlargha.feature.battlepassWinter2025.databinding.WinterBattlepassTaskRewardItemBinding;
import ru.mrlargha.feature.battlepassWinter2025.utils.ArizonaRewardIconUrl;
/* compiled from: RewardsTasksAdapter.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0019\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/RodinaBattlePassTaskRewardItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "isArizona", "", "cdnBaseUrlProvider", "Lkotlin/Function0;", "", "<init>", "(Landroid/view/View;ZLkotlin/jvm/functions/Function0;)V", "binding", "Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassTaskRewardItemBinding;", "getBinding", "()Lru/mrlargha/feature/battlepassWinter2025/databinding/WinterBattlepassTaskRewardItemBinding;", "loadImageJob", "Lkotlinx/coroutines/Job;", "bind", "", "reward", "Lru/mrlargha/feature/battlepassWinter2025/data/CommonTaskReward;", "loadArizonaRewardIcon", "itemId", "", "loadArchiveRewardIcon", "cancelImageLoading", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RodinaBattlePassTaskRewardItemViewHolder extends RecyclerView.ViewHolder {
    private final WinterBattlepassTaskRewardItemBinding binding;
    private final Function0<String> cdnBaseUrlProvider;
    private final boolean isArizona;
    private Job loadImageJob;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RodinaBattlePassTaskRewardItemViewHolder(View view, boolean z, Function0<String> cdnBaseUrlProvider) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(cdnBaseUrlProvider, "cdnBaseUrlProvider");
        this.isArizona = z;
        this.cdnBaseUrlProvider = cdnBaseUrlProvider;
        WinterBattlepassTaskRewardItemBinding bind = WinterBattlepassTaskRewardItemBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
    }

    public final WinterBattlepassTaskRewardItemBinding getBinding() {
        return this.binding;
    }

    public final void bind(CommonTaskReward reward) {
        Intrinsics.checkNotNullParameter(reward, "reward");
        this.binding.taskInfoRewardItemName.setText(reward.getName());
        cancelImageLoading();
        if (this.isArizona) {
            loadArizonaRewardIcon(reward.getItem());
        } else {
            loadArchiveRewardIcon(reward.getItem());
        }
    }

    private final void loadArizonaRewardIcon(int i) {
        ImageView taskInfoRewardItemImage = this.binding.taskInfoRewardItemImage;
        Intrinsics.checkNotNullExpressionValue(taskInfoRewardItemImage, "taskInfoRewardItemImage");
        int i2 = ru.mrlargha.commonui.R.drawable.image_placeholder;
        taskInfoRewardItemImage.setImageResource(i2);
        String obj = StringsKt.trim((CharSequence) this.cdnBaseUrlProvider.invoke()).toString();
        if (obj.length() == 0) {
            Context context = this.binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            UtilsKt.setNotLoadedImage(taskInfoRewardItemImage, context);
            return;
        }
        Picasso.get().load(ArizonaRewardIconUrl.INSTANCE.build(obj, i)).placeholder(i2).error(i2).into(taskInfoRewardItemImage);
    }

    private final void loadArchiveRewardIcon(int i) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new RodinaBattlePassTaskRewardItemViewHolder$loadArchiveRewardIcon$1(this, i, null), 3, null);
        this.loadImageJob = launch$default;
    }

    public final void cancelImageLoading() {
        Job job = this.loadImageJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.loadImageJob = null;
        Picasso.get().cancelRequest(this.binding.taskInfoRewardItemImage);
    }
}
