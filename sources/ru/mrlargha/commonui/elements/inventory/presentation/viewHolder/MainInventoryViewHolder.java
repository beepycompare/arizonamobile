package ru.mrlargha.commonui.elements.inventory.presentation.viewHolder;

import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ItemInventoryBinding;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.inventory.presentation.UtilKt;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.DraggedItem;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.MainInventoryAdapter;
import ru.mrlargha.commonui.utils.InventoryDragState;
import ru.mrlargha.commonui.utils.InventoryIconRequest;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: MainInventoryViewHolder.kt */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0013\u0018\u0000 -2\u00020\u0001:\u0001-B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001bJ\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001fH\u0002J \u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0002J\u0018\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/viewHolder/MainInventoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemInventoryBinding;", "params", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/MainInventoryAdapter$Params;", "<init>", "(Lru/mrlargha/commonui/databinding/ItemInventoryBinding;Lru/mrlargha/commonui/elements/inventory/presentation/adapter/MainInventoryAdapter$Params;)V", "scrollSpeed", "", "edgeHeight", "scrollDirection", "countDownTimer", "Landroid/os/CountDownTimer;", "scrollHandler", "Landroid/os/Handler;", "getScrollHandler", "()Landroid/os/Handler;", "scrollRunnable", "ru/mrlargha/commonui/elements/inventory/presentation/viewHolder/MainInventoryViewHolder$scrollRunnable$1", "Lru/mrlargha/commonui/elements/inventory/presentation/viewHolder/MainInventoryViewHolder$scrollRunnable$1;", "loadImageJob", "Lkotlinx/coroutines/Job;", "imageRequestGeneration", "", "effectLoadJob", "bind", "", "itemVal", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "isWalletVisible", "", "recycle", "clearAsyncResources", "clearEffects", "formatHMS", "", "hours", "minutes", "seconds", "getDragPageEdgeDirection", "view", "Landroid/view/View;", "dragEvent", "Landroid/view/DragEvent;", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MainInventoryViewHolder extends RecyclerView.ViewHolder {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final float MAIN_INVENTORY_DRAG_EDGE_CELL_RATIO = 0.75f;
    private final ItemInventoryBinding binding;
    private CountDownTimer countDownTimer;
    private final int edgeHeight;
    private Job effectLoadJob;
    private long imageRequestGeneration;
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

    /* JADX WARN: Type inference failed for: r0v41, types: [ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.MainInventoryViewHolder$bind$1$5] */
    public final void bind(final InventoryItem itemVal, final boolean z) {
        final InventoryItem inventoryItem;
        Job launch$default;
        final MainInventoryViewHolder mainInventoryViewHolder = this;
        Intrinsics.checkNotNullParameter(itemVal, "itemVal");
        final ItemInventoryBinding itemInventoryBinding = mainInventoryViewHolder.binding;
        mainInventoryViewHolder.clearAsyncResources(false);
        ItemsInfo itemInfo = UtilsKt.getItemInfo(itemVal.getItem());
        TextView tvTitleText = itemInventoryBinding.tvTitleText;
        Intrinsics.checkNotNullExpressionValue(tvTitleText, "tvTitleText");
        tvTitleText.setVisibility(0);
        itemInventoryBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.MainInventoryViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean bind$lambda$0$0;
                bind$lambda$0$0 = MainInventoryViewHolder.bind$lambda$0$0(InventoryItem.this, z, mainInventoryViewHolder, view);
                return bind$lambda$0$0;
            }
        });
        itemInventoryBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.MainInventoryViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainInventoryViewHolder.bind$lambda$0$1(MainInventoryViewHolder.this, itemVal, view);
            }
        });
        itemInventoryBinding.getRoot().setOnDragListener(new View.OnDragListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.MainInventoryViewHolder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnDragListener
            public final boolean onDrag(View view, DragEvent dragEvent) {
                boolean bind$lambda$0$2;
                bind$lambda$0$2 = MainInventoryViewHolder.bind$lambda$0$2(MainInventoryViewHolder.this, view, dragEvent);
                return bind$lambda$0$2;
            }
        });
        boolean z2 = true;
        InventoryIconRequest inventoryIconRequest = UtilsKt.toInventoryIconRequest(itemVal, !UtilsKt.isArizonaType());
        if (inventoryIconRequest != null) {
            itemInventoryBinding.ivItemImage.setImageResource(R.drawable.ic_empty_item);
            Bitmap cachedInventoryIcon = UtilsKt.getCachedInventoryIcon(inventoryIconRequest);
            if (cachedInventoryIcon == null) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new MainInventoryViewHolder$bind$1$4(mainInventoryViewHolder.imageRequestGeneration, mainInventoryViewHolder, inventoryIconRequest, itemInventoryBinding, itemVal, null), 3, null);
                mainInventoryViewHolder.loadImageJob = launch$default;
            } else {
                ImageView ivItemImage = itemInventoryBinding.ivItemImage;
                Intrinsics.checkNotNullExpressionValue(ivItemImage, "ivItemImage");
                UtilsKt.setImage(ivItemImage, cachedInventoryIcon);
            }
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
        ivActiveItem.setVisibility(itemInfo != null && itemInfo.getActive() == 1 ? 0 : 8);
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
            CountDownTimer countDownTimer = mainInventoryViewHolder.countDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            inventoryItem = itemVal;
            ?? r0 = new CountDownTimer(longValue) { // from class: ru.mrlargha.commonui.elements.inventory.presentation.viewHolder.MainInventoryViewHolder$bind$1$5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    String formatHMS;
                    CountDownTimer countDownTimer2;
                    int i = (int) (j / DurationKt.MILLIS_IN_HOUR);
                    int i2 = (int) ((j % DurationKt.MILLIS_IN_HOUR) / 60000);
                    int i3 = (int) ((j % 60000) / 1000);
                    ItemInventoryBinding itemInventoryBinding2 = itemInventoryBinding;
                    if (i > 24) {
                        itemInventoryBinding2.tvTitleText.setText(inventoryItem.getText());
                        countDownTimer2 = mainInventoryViewHolder.countDownTimer;
                        if (countDownTimer2 != null) {
                            countDownTimer2.cancel();
                        }
                        mainInventoryViewHolder.countDownTimer = null;
                        return;
                    }
                    TextView textView = itemInventoryBinding2.tvTitleText;
                    formatHMS = mainInventoryViewHolder.formatHMS(i, i2, i3);
                    textView.setText(formatHMS);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    TextView tvTitleText2 = itemInventoryBinding.tvTitleText;
                    Intrinsics.checkNotNullExpressionValue(tvTitleText2, "tvTitleText");
                    tvTitleText2.setVisibility(8);
                    mainInventoryViewHolder.countDownTimer = null;
                }
            };
            itemInventoryBinding = itemInventoryBinding;
            mainInventoryViewHolder = mainInventoryViewHolder;
            mainInventoryViewHolder.countDownTimer = r0.start();
        } else {
            inventoryItem = itemVal;
            itemInventoryBinding.tvTitleText.setText(UtilKt.inventoryItemDisplayText(inventoryItem.getText(), inventoryItem.getItem_type(), inventoryItem.getEnchant()));
            CountDownTimer countDownTimer2 = mainInventoryViewHolder.countDownTimer;
            if (countDownTimer2 != null) {
                countDownTimer2.cancel();
            }
        }
        if (inventoryItem.isLocked()) {
            itemInventoryBinding.ivItemImage.setImageResource(R.drawable.ic_locked_item);
            itemInventoryBinding.tvTitleText.setText("");
        }
        mainInventoryViewHolder.effectLoadJob = UtilKt.setInventoryItemEffect(itemInventoryBinding, inventoryItem);
        ImageView ivItemImage2 = itemInventoryBinding.ivItemImage;
        Intrinsics.checkNotNullExpressionValue(ivItemImage2, "ivItemImage");
        ImageView imageView = ivItemImage2;
        Boolean loading = inventoryItem.getLoading();
        imageView.setVisibility(!(loading != null ? loading.booleanValue() : false) ? 0 : 8);
        ProgressBar itemProgressBar = itemInventoryBinding.itemProgressBar;
        Intrinsics.checkNotNullExpressionValue(itemProgressBar, "itemProgressBar");
        ProgressBar progressBar = itemProgressBar;
        Boolean loading2 = inventoryItem.getLoading();
        progressBar.setVisibility(loading2 != null ? loading2.booleanValue() : false ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$0$0(InventoryItem inventoryItem, boolean z, MainInventoryViewHolder mainInventoryViewHolder, View view) {
        if (inventoryItem.getItem() == null || z) {
            return false;
        }
        mainInventoryViewHolder.params.getOnLongClicked().invoke(inventoryItem);
        Intrinsics.checkNotNull(view);
        UtilsKt.setDragClick(inventoryItem, view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$1(MainInventoryViewHolder mainInventoryViewHolder, InventoryItem inventoryItem, View view) {
        mainInventoryViewHolder.params.getOnItemClicked().invoke(inventoryItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$0$2(MainInventoryViewHolder mainInventoryViewHolder, View view, DragEvent dragEvent) {
        switch (dragEvent.getAction()) {
            case 1:
                Intrinsics.checkNotNull(dragEvent);
                return UtilsKt.getInventoryDragState(dragEvent) != null;
            case 2:
                Function1<Integer, Unit> onDragPageEdgeChanged = mainInventoryViewHolder.params.getOnDragPageEdgeChanged();
                Intrinsics.checkNotNull(view);
                Intrinsics.checkNotNull(dragEvent);
                onDragPageEdgeChanged.invoke(Integer.valueOf(mainInventoryViewHolder.getDragPageEdgeDirection(view, dragEvent)));
                return true;
            case 3:
                mainInventoryViewHolder.params.getOnDragPageEdgeChanged().invoke(0);
                Intrinsics.checkNotNull(dragEvent);
                InventoryDragState inventoryDragState = UtilsKt.getInventoryDragState(dragEvent);
                if (inventoryDragState != null) {
                    mainInventoryViewHolder.params.getOnItemDropped().invoke(new DraggedItem(inventoryDragState.getItem(), mainInventoryViewHolder.getAbsoluteAdapterPosition()));
                }
                view.invalidate();
                InventoryDragState inventoryDragState2 = UtilsKt.getInventoryDragState(dragEvent);
                View sourceView = inventoryDragState2 != null ? inventoryDragState2.getSourceView() : null;
                CardView cardView = sourceView instanceof CardView ? (CardView) sourceView : null;
                if (cardView != null) {
                    ViewParent parent = cardView.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (cardView.isAttachedToWindow() && viewGroup != null) {
                        viewGroup.removeView(cardView);
                    }
                }
                mainInventoryViewHolder.scrollHandler.removeCallbacks(mainInventoryViewHolder.scrollRunnable);
                return true;
            case 4:
                mainInventoryViewHolder.params.getOnDragPageEdgeChanged().invoke(0);
                mainInventoryViewHolder.scrollHandler.removeCallbacks(mainInventoryViewHolder.scrollRunnable);
                Intrinsics.checkNotNull(dragEvent);
                InventoryDragState inventoryDragState3 = UtilsKt.getInventoryDragState(dragEvent);
                if (inventoryDragState3 != null) {
                    InventoryDragState inventoryDragState4 = inventoryDragState3.getSourceView() == view ? inventoryDragState3 : null;
                    if (inventoryDragState4 != null) {
                        mainInventoryViewHolder.params.getOnDragEnded().invoke(inventoryDragState4.getItem());
                    }
                }
                view.invalidate();
                return true;
            case 5:
                Function1<Integer, Unit> onDragPageEdgeChanged2 = mainInventoryViewHolder.params.getOnDragPageEdgeChanged();
                Intrinsics.checkNotNull(view);
                Intrinsics.checkNotNull(dragEvent);
                onDragPageEdgeChanged2.invoke(Integer.valueOf(mainInventoryViewHolder.getDragPageEdgeDirection(view, dragEvent)));
                Object[] objArr = view.getBottom() + mainInventoryViewHolder.edgeHeight >= mainInventoryViewHolder.params.getRecyclerView().getBottom() - mainInventoryViewHolder.params.getRecyclerView().getTop() ? 1 : null;
                Object[] objArr2 = view.getTop() - mainInventoryViewHolder.edgeHeight <= 0 ? 1 : null;
                if (objArr != null) {
                    mainInventoryViewHolder.scrollDirection = 1;
                } else if (objArr2 != null) {
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
            case 6:
                mainInventoryViewHolder.params.getOnDragPageEdgeChanged().invoke(0);
                mainInventoryViewHolder.scrollHandler.removeCallbacks(mainInventoryViewHolder.scrollRunnable);
                view.invalidate();
                return true;
            default:
                return false;
        }
    }

    public final void recycle() {
        clearAsyncResources(true);
    }

    private final void clearAsyncResources(boolean z) {
        ItemInventoryBinding itemInventoryBinding = this.binding;
        this.imageRequestGeneration++;
        Job job = this.loadImageJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.loadImageJob = null;
        Job job2 = this.effectLoadJob;
        if (job2 != null) {
            Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.effectLoadJob = null;
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countDownTimer = null;
        this.scrollHandler.removeCallbacks(this.scrollRunnable);
        itemInventoryBinding.ivItemImage.setImageDrawable(null);
        if (z) {
            UtilKt.clearInventoryItemEffect(itemInventoryBinding);
        }
    }

    private static final String formatHMS$two(int i) {
        return i < 10 ? "0" + i : String.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatHMS(int i, int i2, int i3) {
        String formatHMS$two = formatHMS$two(i);
        String formatHMS$two2 = formatHMS$two(i2);
        return formatHMS$two + StringUtils.PROCESS_POSTFIX_DELIMITER + formatHMS$two2 + StringUtils.PROCESS_POSTFIX_DELIMITER + formatHMS$two(i3);
    }

    private final int getDragPageEdgeDirection(View view, DragEvent dragEvent) {
        int absoluteAdapterPosition = getAbsoluteAdapterPosition();
        RecyclerView.LayoutManager layoutManager = this.params.getRecyclerView().getLayoutManager();
        GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
        if (gridLayoutManager != null) {
            int spanCount = gridLayoutManager.getSpanCount();
            if (absoluteAdapterPosition != -1 && view.getWidth() > 0 && spanCount > 1) {
                int max = Math.max(this.params.getContext().getResources().getDimensionPixelSize(R.dimen._24sdp), (int) (view.getWidth() * 0.75f));
                int i = absoluteAdapterPosition % spanCount;
                if (i == 0 && dragEvent.getX() <= max) {
                    return -1;
                }
                if (i == spanCount - 1 && dragEvent.getX() >= view.getWidth() - max) {
                    return 1;
                }
            }
        }
        return 0;
    }

    /* compiled from: MainInventoryViewHolder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/viewHolder/MainInventoryViewHolder$Companion;", "", "<init>", "()V", "MAIN_INVENTORY_DRAG_EDGE_CELL_RATIO", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
