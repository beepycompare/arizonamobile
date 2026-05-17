package ru.mrlargha.event.adapters;

import android.graphics.Color;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.event.data.AwardItemData;
import ru.mrlargha.feature.event.databinding.EventAwardItemBinding;
/* compiled from: AwardsAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/mrlargha/event/adapters/LevelItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "completeColor", "", "itemView", "Landroid/view/View;", "onClaimItem", "Lkotlin/Function2;", "", "", "<init>", "(ILandroid/view/View;Lkotlin/jvm/functions/Function2;)V", "levelPassedColor", "levelNotPassedColor", "binding", "Lru/mrlargha/feature/event/databinding/EventAwardItemBinding;", "loadImageJob", "Lkotlinx/coroutines/Job;", "bind", "award", "Lru/mrlargha/event/data/AwardItemData;", "position", FirebaseAnalytics.Param.LEVEL, NotificationCompat.CATEGORY_EVENT}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LevelItemViewHolder extends RecyclerView.ViewHolder {
    private final EventAwardItemBinding binding;
    private final int completeColor;
    private final int levelNotPassedColor;
    private final int levelPassedColor;
    private Job loadImageJob;
    private final Function2<Boolean, Integer, Unit> onClaimItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LevelItemViewHolder(int i, View itemView, Function2<? super Boolean, ? super Integer, Unit> onClaimItem) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(onClaimItem, "onClaimItem");
        this.completeColor = i;
        this.onClaimItem = onClaimItem;
        this.levelPassedColor = i;
        this.levelNotPassedColor = Color.parseColor("#343940");
        EventAwardItemBinding bind = EventAwardItemBinding.bind(itemView);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
    }

    public /* synthetic */ LevelItemViewHolder(int i, View view, Function2 function2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, view, (i2 & 4) != 0 ? new Function2() { // from class: ru.mrlargha.event.adapters.LevelItemViewHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit unit;
                ((Boolean) obj).booleanValue();
                ((Integer) obj2).intValue();
                unit = Unit.INSTANCE;
                return unit;
            }
        } : function2);
    }

    public final void bind(final AwardItemData award, int i, int i2) {
        Intrinsics.checkNotNullParameter(award, "award");
        final int i3 = i + 1;
        Job job = this.loadImageJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        final EventAwardItemBinding eventAwardItemBinding = this.binding;
        eventAwardItemBinding.levelText.setText(String.valueOf(i3));
        eventAwardItemBinding.levelText.setTextColor(Color.parseColor("#16191D"));
        if (i3 < i2) {
            eventAwardItemBinding.viewBeforeLevel.setBackgroundColor(this.levelPassedColor);
            eventAwardItemBinding.levelContainer.setColorFilter(this.levelPassedColor);
            eventAwardItemBinding.viewAfterLevel.setBackgroundColor(this.levelPassedColor);
        } else if (i3 == i2) {
            eventAwardItemBinding.viewBeforeLevel.setBackgroundColor(this.levelPassedColor);
            eventAwardItemBinding.levelContainer.setColorFilter(this.levelPassedColor);
            eventAwardItemBinding.viewAfterLevel.setBackgroundColor(this.levelNotPassedColor);
        } else {
            eventAwardItemBinding.levelText.setTextColor(-1);
            eventAwardItemBinding.viewBeforeLevel.setBackgroundColor(this.levelNotPassedColor);
            eventAwardItemBinding.levelContainer.setColorFilter(this.levelNotPassedColor);
            eventAwardItemBinding.viewAfterLevel.setBackgroundColor(this.levelNotPassedColor);
        }
        eventAwardItemBinding.itemLevelNameUsually.setText(award.getTitle());
        if (UtilsKt.isArizonaType()) {
            Picasso picasso = Picasso.get();
            String projectResourceUrl$default = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            picasso.load(projectResourceUrl$default + "/systems/battlepass/easter-2026/" + award.getSysName() + ".webp").into(eventAwardItemBinding.itemLevelIcUsually);
        } else {
            Picasso picasso2 = Picasso.get();
            String projectResourceUrl$default2 = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            picasso2.load(projectResourceUrl$default2 + "/systems/battlepass/items/" + award.getSysName() + ".webp").into(eventAwardItemBinding.itemLevelIcUsually);
        }
        eventAwardItemBinding.locked.setVisibility(8);
        eventAwardItemBinding.received.setVisibility(8);
        eventAwardItemBinding.button.setVisibility(8);
        if (award.isAvailable() && i3 <= i2) {
            eventAwardItemBinding.button.setVisibility(0);
            eventAwardItemBinding.button.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.adapters.LevelItemViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LevelItemViewHolder.bind$lambda$0$0(EventAwardItemBinding.this, award, this, i3, view);
                }
            });
        } else if (i3 > i2) {
            eventAwardItemBinding.locked.setVisibility(0);
        } else {
            eventAwardItemBinding.received.setVisibility(0);
        }
        if (award.getSysName() == -1) {
            eventAwardItemBinding.itemLevelUsuallyContainer.setVisibility(4);
        } else {
            eventAwardItemBinding.itemLevelUsuallyContainer.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$0(EventAwardItemBinding eventAwardItemBinding, AwardItemData awardItemData, LevelItemViewHolder levelItemViewHolder, int i, View view) {
        eventAwardItemBinding.button.setVisibility(4);
        awardItemData.setWasClicked(true);
        levelItemViewHolder.onClaimItem.invoke(false, Integer.valueOf(i));
    }
}
