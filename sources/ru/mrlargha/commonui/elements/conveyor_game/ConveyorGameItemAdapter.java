package ru.mrlargha.commonui.elements.conveyor_game;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ConveyorGameItemBinding;
import ru.mrlargha.commonui.elements.conveyor_game.ConveyorGameItemAdapter;
/* compiled from: ConveyorGameItemAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001f BF\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u000bJ\u001c\u0010\u0018\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\u001c\u0010\u001c\u001a\u00020\u000b2\n\u0010\u001d\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lru/mrlargha/commonui/elements/conveyor_game/ConveyorGameItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/conveyor_game/ConveyorGameItemModel;", "Lru/mrlargha/commonui/elements/conveyor_game/ConveyorGameItemAdapter$ConveyorGameViewHolder;", "isItem", "", "onClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "itemModel", "", "refreshItems", "Lkotlin/Function0;", "<init>", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "oldSelectItemId", "", "selectItemId", "isStartAnimation", "isHasAnimation", "setIsHasAnimation", "correctSelectItem", "startAnimation", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "ConveyorGameViewHolder", "DiffUtilCallback", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConveyorGameItemAdapter extends ListAdapter<ConveyorGameItemModel, ConveyorGameViewHolder> {
    private boolean isHasAnimation;
    private final boolean isItem;
    private boolean isStartAnimation;
    private int oldSelectItemId;
    private final Function1<ConveyorGameItemModel, Unit> onClick;
    private final Function0<Unit> refreshItems;
    private int selectItemId;

    public /* synthetic */ ConveyorGameItemAdapter(boolean z, Function1 function1, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, function1, (i & 4) != 0 ? null : function0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ConveyorGameItemAdapter(boolean z, Function1<? super ConveyorGameItemModel, Unit> onClick, Function0<Unit> function0) {
        super(new DiffUtilCallback());
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.isItem = z;
        this.onClick = onClick;
        this.refreshItems = function0;
        this.oldSelectItemId = -1;
        this.selectItemId = -1;
        this.isHasAnimation = true;
    }

    /* compiled from: ConveyorGameItemAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/conveyor_game/ConveyorGameItemAdapter$ConveyorGameViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ConveyorGameItemBinding;", "<init>", "(Lru/mrlargha/commonui/elements/conveyor_game/ConveyorGameItemAdapter;Lru/mrlargha/commonui/databinding/ConveyorGameItemBinding;)V", "startDownAndUpAnimation", "", "onBind", "itemModel", "Lru/mrlargha/commonui/elements/conveyor_game/ConveyorGameItemModel;", "position", "", "setupListeners", "scaleAnimation", "view", "Landroid/view/View;", "isSelect", "", "checkIsAllItemSelect", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class ConveyorGameViewHolder extends RecyclerView.ViewHolder {
        private final ConveyorGameItemBinding binding;
        final /* synthetic */ ConveyorGameItemAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConveyorGameViewHolder(ConveyorGameItemAdapter conveyorGameItemAdapter, ConveyorGameItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = conveyorGameItemAdapter;
            this.binding = binding;
        }

        private final void startDownAndUpAnimation() {
            this.binding.ivItem.startAnimation(AnimationUtils.loadAnimation(this.binding.ivItem.getContext(), R.anim.fade_down_and_up));
        }

        public final void onBind(ConveyorGameItemModel itemModel, int i) {
            Intrinsics.checkNotNullParameter(itemModel, "itemModel");
            FrameLayout root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            root.setVisibility(0);
            this.binding.ivItem.setImageResource(itemModel.getImage());
            setupListeners(itemModel, i);
            if (i != this.this$0.selectItemId) {
                if (this.this$0.isStartAnimation) {
                    this.binding.getRoot().setScaleX(1.0f);
                    this.binding.getRoot().setScaleY(1.0f);
                } else {
                    FrameLayout root2 = this.binding.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
                    scaleAnimation(root2, false);
                }
            } else {
                FrameLayout root3 = this.binding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
                scaleAnimation(root3, true);
            }
            if (this.this$0.isHasAnimation || !this.this$0.isItem) {
                return;
            }
            checkIsAllItemSelect();
        }

        private final void setupListeners(final ConveyorGameItemModel conveyorGameItemModel, final int i) {
            FrameLayout root = this.binding.getRoot();
            final ConveyorGameItemAdapter conveyorGameItemAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.conveyor_game.ConveyorGameItemAdapter$ConveyorGameViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConveyorGameItemAdapter.ConveyorGameViewHolder.setupListeners$lambda$0(ConveyorGameItemAdapter.this, conveyorGameItemModel, i, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setupListeners$lambda$0(ConveyorGameItemAdapter conveyorGameItemAdapter, ConveyorGameItemModel conveyorGameItemModel, int i, ConveyorGameViewHolder conveyorGameViewHolder, View view) {
            conveyorGameItemAdapter.onClick.invoke(conveyorGameItemModel);
            if (conveyorGameItemAdapter.isItem) {
                conveyorGameItemAdapter.oldSelectItemId = conveyorGameItemAdapter.selectItemId;
                conveyorGameItemAdapter.selectItemId = i;
                conveyorGameItemAdapter.notifyItemChanged(conveyorGameItemAdapter.oldSelectItemId);
                conveyorGameItemAdapter.notifyItemChanged(conveyorGameItemAdapter.selectItemId);
                return;
            }
            conveyorGameViewHolder.startDownAndUpAnimation();
        }

        private final void scaleAnimation(View view, boolean z) {
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.0f, 1.2f);
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.0f, 1.2f);
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.2f, 1.0f);
            PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.2f, 1.0f);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, ofFloat, ofFloat2);
            ofPropertyValuesHolder.setDuration(300L);
            Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "apply(...)");
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, ofFloat3, ofFloat4);
            ofPropertyValuesHolder2.setDuration(300L);
            Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder2, "apply(...)");
            if (z) {
                ofPropertyValuesHolder.start();
            } else {
                ofPropertyValuesHolder2.start();
            }
        }

        private final void checkIsAllItemSelect() {
            Function0 function0;
            List<ConveyorGameItemModel> currentList = this.this$0.getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
            List<ConveyorGameItemModel> list = currentList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ConveyorGameItemModel conveyorGameItemModel : list) {
                arrayList.add(Integer.valueOf(conveyorGameItemModel.getImage()));
            }
            if (CollectionsKt.distinct(arrayList).size() != 1 || (function0 = this.this$0.refreshItems) == null) {
                return;
            }
            function0.invoke();
        }
    }

    public final void setIsHasAnimation(boolean z) {
        this.isHasAnimation = z;
    }

    public final void correctSelectItem(ConveyorGameItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        if (this.isItem) {
            ArrayList arrayList = new ArrayList();
            List<ConveyorGameItemModel> currentList = getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
            for (ConveyorGameItemModel conveyorGameItemModel : currentList) {
                if (conveyorGameItemModel.getId() == itemModel.getId()) {
                    arrayList.add(itemModel);
                } else {
                    Intrinsics.checkNotNull(conveyorGameItemModel);
                    arrayList.add(conveyorGameItemModel);
                }
            }
            submitList(arrayList);
            notifyItemChanged(this.selectItemId);
            this.selectItemId = -1;
        }
    }

    public final void startAnimation() {
        this.isStartAnimation = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ConveyorGameViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ConveyorGameItemBinding inflate = ConveyorGameItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ConveyorGameViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ConveyorGameViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ConveyorGameItemModel conveyorGameItemModel = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(conveyorGameItemModel, "get(...)");
        holder.onBind(conveyorGameItemModel, i);
        if (i + 1 == getCurrentList().size() && this.isItem && this.isStartAnimation) {
            ConveyorGameScreen.Companion.startAnimation();
            this.isStartAnimation = false;
        }
    }

    /* compiled from: ConveyorGameItemAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/conveyor_game/ConveyorGameItemAdapter$DiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/mrlargha/commonui/elements/conveyor_game/ConveyorGameItemModel;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class DiffUtilCallback extends DiffUtil.ItemCallback<ConveyorGameItemModel> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(ConveyorGameItemModel oldItem, ConveyorGameItemModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(ConveyorGameItemModel oldItem, ConveyorGameItemModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId() && oldItem.getImage() == newItem.getImage();
        }
    }
}
