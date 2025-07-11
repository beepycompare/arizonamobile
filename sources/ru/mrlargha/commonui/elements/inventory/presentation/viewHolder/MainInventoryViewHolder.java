package ru.mrlargha.commonui.elements.inventory.presentation.viewHolder;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.adjust.sdk.Constants;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ItemInventoryBinding;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.DraggedItem;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.MainInventoryAdapter;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: MainInventoryViewHolder.kt */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0013\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/viewHolder/MainInventoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemInventoryBinding;", "params", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/MainInventoryAdapter$Params;", "<init>", "(Lru/mrlargha/commonui/databinding/ItemInventoryBinding;Lru/mrlargha/commonui/elements/inventory/presentation/adapter/MainInventoryAdapter$Params;)V", "scrollSpeed", "", "edgeHeight", "scrollDirection", "countDownTimer", "Landroid/os/CountDownTimer;", "scrollHandler", "Landroid/os/Handler;", "getScrollHandler", "()Landroid/os/Handler;", "scrollRunnable", "ru/mrlargha/commonui/elements/inventory/presentation/viewHolder/MainInventoryViewHolder$scrollRunnable$1", "Lru/mrlargha/commonui/elements/inventory/presentation/viewHolder/MainInventoryViewHolder$scrollRunnable$1;", "loadImageJob", "Lkotlinx/coroutines/Job;", "bind", "", "itemVal", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "isWalletVisible", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MainInventoryViewHolder extends RecyclerView.ViewHolder {
    private final ItemInventoryBinding binding;
    private CountDownTimer countDownTimer;
    private final int edgeHeight;
    private Job loadImageJob;
    private final MainInventoryAdapter.Params params;
    private int scrollDirection;
    private final Handler scrollHandler;
    private final MainInventoryViewHolder$scrollRunnable$1 scrollRunnable;
    private final int scrollSpeed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v5, types: [ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.MainInventoryViewHolder$scrollRunnable$1] */
    public MainInventoryViewHolder(ItemInventoryBinding binding, MainInventoryAdapter.Params params) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(params, "params");
        this.binding = binding;
        this.params = params;
        this.scrollSpeed = 30;
        this.edgeHeight = 100;
        this.scrollDirection = 1;
        this.scrollHandler = new Handler(Looper.getMainLooper());
        this.scrollRunnable = new Runnable() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.MainInventoryViewHolder$scrollRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                MainInventoryAdapter.Params params2;
                int i;
                int i2;
                params2 = MainInventoryViewHolder.this.params;
                RecyclerView recyclerView = params2.getRecyclerView();
                i = MainInventoryViewHolder.this.scrollDirection;
                i2 = MainInventoryViewHolder.this.scrollSpeed;
                recyclerView.scrollBy(0, i * i2);
                MainInventoryViewHolder.this.getScrollHandler().postDelayed(this, 10L);
            }
        };
    }

    public final Handler getScrollHandler() {
        return this.scrollHandler;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.MainInventoryViewHolder$bind$1$6] */
    public final void bind(final InventoryItem itemVal, final boolean z) {
        final InventoryItem inventoryItem;
        Job launch$default;
        Intrinsics.checkNotNullParameter(itemVal, "itemVal");
        final ItemInventoryBinding itemInventoryBinding = this.binding;
        TextView tvTitleText = itemInventoryBinding.tvTitleText;
        Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
        tvTitleText.setVisibility(0);
        itemInventoryBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.MainInventoryViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean bind$lambda$4$lambda$0;
                bind$lambda$4$lambda$0 = MainInventoryViewHolder.bind$lambda$4$lambda$0(InventoryItem.this, z, this, view);
                return bind$lambda$4$lambda$0;
            }
        });
        itemInventoryBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.MainInventoryViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainInventoryViewHolder.bind$lambda$4$lambda$1(MainInventoryViewHolder.this, itemVal, view);
            }
        });
        itemInventoryBinding.getRoot().setOnDragListener(new View.OnDragListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.MainInventoryViewHolder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnDragListener
            public final boolean onDrag(View view, DragEvent dragEvent) {
                boolean bind$lambda$4$lambda$2;
                bind$lambda$4$lambda$2 = MainInventoryViewHolder.bind$lambda$4$lambda$2(MainInventoryViewHolder.this, view, dragEvent);
                return bind$lambda$4$lambda$2;
            }
        });
        Job job = this.loadImageJob;
        Object obj = null;
        boolean z2 = true;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (itemVal.getItem() != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new MainInventoryViewHolder$bind$1$4(itemInventoryBinding, this, itemVal, null), 3, null);
            this.loadImageJob = launch$default;
        } else {
            itemInventoryBinding.ivItemImage.setImageResource(R.drawable.ic_empty_item);
        }
        if (itemVal.getColor() != null) {
            CardView cvColoredItem = itemInventoryBinding.cvColoredItem;
            Intrinsics.checkNotNullExpressionValue(cvColoredItem, "cvColoredItem");
            cvColoredItem.setVisibility(0);
            itemInventoryBinding.cvColoredItem.setCardBackgroundColor(UtilsKt.getColorTint(itemVal.getColor().intValue()));
        } else {
            CardView cvColoredItem2 = itemInventoryBinding.cvColoredItem;
            Intrinsics.checkNotNullExpressionValue(cvColoredItem2, "cvColoredItem");
            cvColoredItem2.setVisibility(8);
        }
        AppCompatImageView ivActiveItem = itemInventoryBinding.ivActiveItem;
        Intrinsics.checkNotNullExpressionValue(ivActiveItem, "ivActiveItem");
        AppCompatImageView appCompatImageView = ivActiveItem;
        Iterator<T> it = UtilsKt.getItemsName().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int id = ((ItemsInfo) next).getId();
            Integer item = itemVal.getItem();
            if (item != null && id == item.intValue()) {
                obj = next;
                break;
            }
        }
        ItemsInfo itemsInfo = (ItemsInfo) obj;
        appCompatImageView.setVisibility(itemsInfo != null && itemsInfo.getActive() == 1 ? 0 : 8);
        View viewCenter = itemInventoryBinding.viewCenter;
        Intrinsics.checkNotNullExpressionValue(viewCenter, "viewCenter");
        Integer blackout = itemVal.getBlackout();
        if (blackout == null || blackout.intValue() != 1) {
            z2 = false;
        }
        viewCenter.setVisibility(z2 ? 0 : 8);
        if (itemVal.getBackground() == null) {
            ImageView ivDefaultItem = itemInventoryBinding.ivDefaultItem;
            Intrinsics.checkNotNullExpressionValue(ivDefaultItem, "ivDefaultItem");
            ivDefaultItem.setVisibility(0);
            itemInventoryBinding.ivDefaultItem.setBackgroundColor(0);
            itemInventoryBinding.item.setCardBackgroundColor(0);
            itemInventoryBinding.ivItemImage.setBackgroundResource(0);
        } else {
            ImageView ivDefaultItem2 = itemInventoryBinding.ivDefaultItem;
            Intrinsics.checkNotNullExpressionValue(ivDefaultItem2, "ivDefaultItem");
            ivDefaultItem2.setVisibility(8);
            itemInventoryBinding.item.setCardBackgroundColor(UtilsKt.getColorTint(itemVal.getBackground().intValue()));
            itemInventoryBinding.ivItemImage.setBackgroundResource(R.drawable.shining_workshop_color);
        }
        Integer available = itemVal.getAvailable();
        if (available != null && available.intValue() == 0) {
            itemInventoryBinding.getRoot().setClickable(false);
            View viewCenter2 = itemInventoryBinding.viewCenter;
            Intrinsics.checkNotNullExpressionValue(viewCenter2, "viewCenter");
            viewCenter2.setVisibility(0);
        }
        if (itemVal.getTime() != null && itemVal.getTime().longValue() > 0) {
            final long longValue = (itemVal.getTime().longValue() * 1000) - System.currentTimeMillis();
            CountDownTimer countDownTimer = this.countDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            inventoryItem = itemVal;
            this.countDownTimer = new CountDownTimer(longValue) { // from class: ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.MainInventoryViewHolder$bind$1$6
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    CountDownTimer countDownTimer2;
                    long j2 = (long) Constants.ONE_HOUR;
                    int i = (int) (j / j2);
                    long j3 = 60000;
                    int i2 = (int) ((j % j2) / j3);
                    int i3 = (int) ((j % j3) / 1000);
                    if (i > 24) {
                        itemInventoryBinding.tvTitleText.setText(inventoryItem.getText());
                        countDownTimer2 = this.countDownTimer;
                        if (countDownTimer2 != null) {
                            countDownTimer2.cancel();
                            return;
                        }
                        return;
                    }
                    TextView textView = itemInventoryBinding.tvTitleText;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}, 3));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    textView.setText(format);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    TextView tvTitleText2 = itemInventoryBinding.tvTitleText;
                    Intrinsics.checkNotNullExpressionValue(tvTitleText2, "tvTitleText");
                    tvTitleText2.setVisibility(8);
                    this.countDownTimer = null;
                }
            }.start();
        } else {
            inventoryItem = itemVal;
            itemInventoryBinding.tvTitleText.setText(inventoryItem.getText());
            CountDownTimer countDownTimer2 = this.countDownTimer;
            if (countDownTimer2 != null) {
                countDownTimer2.cancel();
            }
        }
        if (inventoryItem.isLocked()) {
            itemInventoryBinding.ivItemImage.setImageResource(R.drawable.ic_locked_item);
            itemInventoryBinding.tvTitleText.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$4$lambda$0(InventoryItem inventoryItem, boolean z, MainInventoryViewHolder mainInventoryViewHolder, View view) {
        if (inventoryItem.getItem() == null || z) {
            return false;
        }
        mainInventoryViewHolder.params.getOnLongClicked().invoke(inventoryItem);
        Intrinsics.checkNotNull(view);
        UtilsKt.setDragClick(inventoryItem, view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$4$lambda$1(MainInventoryViewHolder mainInventoryViewHolder, InventoryItem inventoryItem, View view) {
        mainInventoryViewHolder.params.getOnItemClicked().invoke(inventoryItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$4$lambda$2(MainInventoryViewHolder mainInventoryViewHolder, View view, DragEvent dragEvent) {
        int action = dragEvent.getAction();
        if (action != 1) {
            if (action == 3) {
                if (dragEvent.getClipData() != null) {
                    Object fromJson = GsonStore.INSTANCE.getGson().fromJson(UtilsKt.updateJsonString(dragEvent.getClipData().getItemAt(0).getText().toString()), (Class<Object>) InventoryItem.class);
                    Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
                    mainInventoryViewHolder.params.getOnItemDropped().invoke(new DraggedItem((InventoryItem) fromJson, mainInventoryViewHolder.getAbsoluteAdapterPosition()));
                }
                view.invalidate();
                Object localState = dragEvent.getLocalState();
                CardView cardView = localState instanceof CardView ? (CardView) localState : null;
                if (cardView != null) {
                    ViewParent parent = cardView.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (cardView.isAttachedToWindow() && viewGroup != null) {
                        viewGroup.removeView(cardView);
                    }
                }
                mainInventoryViewHolder.scrollHandler.removeCallbacks(mainInventoryViewHolder.scrollRunnable);
                return true;
            }
            if (action != 4) {
                if (action == 5) {
                    boolean z = view.getBottom() + mainInventoryViewHolder.edgeHeight >= mainInventoryViewHolder.params.getRecyclerView().getBottom() - mainInventoryViewHolder.params.getRecyclerView().getTop();
                    boolean z2 = view.getTop() - mainInventoryViewHolder.edgeHeight <= 0;
                    if (z) {
                        mainInventoryViewHolder.scrollDirection = 1;
                    } else if (z2) {
                        mainInventoryViewHolder.scrollDirection = -1;
                    } else {
                        mainInventoryViewHolder.scrollDirection = 0;
                        mainInventoryViewHolder.scrollHandler.removeCallbacks(mainInventoryViewHolder.scrollRunnable);
                    }
                    if (mainInventoryViewHolder.scrollDirection != 0) {
                        mainInventoryViewHolder.scrollHandler.post(mainInventoryViewHolder.scrollRunnable);
                    }
                    view.invalidate();
                    return true;
                } else if (action != 6) {
                    return false;
                }
            }
            mainInventoryViewHolder.scrollHandler.removeCallbacks(mainInventoryViewHolder.scrollRunnable);
            view.invalidate();
            return true;
        }
        return dragEvent.getClipDescription().hasMimeType("text/plain");
    }
}
