package ru.mrlargha.commonui.elements.animation.presentation.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.animation.domain.obj.Animation;
import ru.mrlargha.commonui.elements.animation.domain.obj.AnimationFavourites;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: AnimationAdapter.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016J\u000e\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%J\u0014\u0010&\u001a\u00020\u00182\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0(R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0016¨\u0006*"}, d2 = {"Lru/mrlargha/commonui/elements/animation/presentation/adapter/AnimationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/animation/presentation/adapter/AnimationHolder;", "targetActivity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "context", "Landroid/content/Context;", "animationList", "Ljava/util/ArrayList;", "Lru/mrlargha/commonui/elements/animation/domain/obj/Animation;", "Lkotlin/collections/ArrayList;", "sendServerEvent", "Lru/mrlargha/commonui/core/IBackendNotifier;", "onAnimationClickListener", "Lru/mrlargha/commonui/elements/animation/presentation/adapter/AnimationAdapter$OnAnimationClickListener;", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isArizonaType", "", "()Z", "setOnAnimationClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "onViewRecycled", "getItemCount", "changeFavouriteStatus", "animationFavourites", "Lru/mrlargha/commonui/elements/animation/domain/obj/AnimationFavourites;", "addAnimations", "data", "", "OnAnimationClickListener", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnimationAdapter extends RecyclerView.Adapter<AnimationHolder> {
    private final ArrayList<Animation> animationList;
    private Context context;
    private final boolean isArizonaType;
    private OnAnimationClickListener onAnimationClickListener;
    private final IBackendNotifier sendServerEvent;
    private final SharedPreferences sharedPref;

    /* compiled from: AnimationAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/animation/presentation/adapter/AnimationAdapter$OnAnimationClickListener;", "", "callback", "", "animation", "Lru/mrlargha/commonui/elements/animation/domain/obj/Animation;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnAnimationClickListener {
        void callback(Animation animation);
    }

    public AnimationAdapter(Activity targetActivity) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.animationList = new ArrayList<>();
        this.sendServerEvent = (IBackendNotifier) targetActivity;
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        this.isArizonaType = sharedPreferences.getBoolean("isArizonaType", false);
    }

    public final boolean isArizonaType() {
        return this.isArizonaType;
    }

    public final void setOnAnimationClickListener(OnAnimationClickListener onAnimationClickListener) {
        Intrinsics.checkNotNullParameter(onAnimationClickListener, "onAnimationClickListener");
        this.onAnimationClickListener = onAnimationClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public AnimationHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.context = context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.animation_item, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new AnimationHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final AnimationHolder holder, final int i) {
        Animation animation;
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Context context = null;
        if (this.animationList.get(i).getFavorited() == 1) {
            AppCompatImageView appCompatImageView = holder.getAnimationItemBinding().aiFavorite;
            Context context2 = this.context;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context2 = null;
            }
            appCompatImageView.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.ic_favorites_enabled));
        } else {
            AppCompatImageView appCompatImageView2 = holder.getAnimationItemBinding().aiFavorite;
            Context context3 = this.context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context3 = null;
            }
            appCompatImageView2.setImageDrawable(ContextCompat.getDrawable(context3, R.drawable.ic_favorites_disabled));
        }
        Animation animation2 = this.animationList.get(i);
        Intrinsics.checkNotNullExpressionValue(animation2, "get(...)");
        holder.getAnimationItemBinding().aiTittle.setText(animation2.getName() + " (" + animation.getId() + ")");
        if (this.isArizonaType) {
            str = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/assets/images/animation/img/animations/" + this.animationList.get(i).getImage();
        } else {
            str = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/rodina-rp/assets/images/animation/img/animations/" + this.animationList.get(i).getImage();
        }
        Picasso.get().load(str).into(holder.getAnimationItemBinding().aiImage);
        if (!this.animationList.get(i).isEnabled()) {
            LinearLayout linearLayout = holder.getAnimationItemBinding().aiBackground;
            Context context4 = this.context;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
            } else {
                context = context4;
            }
            linearLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.ic_item_bg));
        }
        holder.getAnimationItemBinding().aiBackground.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.animation.presentation.adapter.AnimationAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnimationAdapter.onBindViewHolder$lambda$2(AnimationAdapter.this, i, holder, view);
            }
        });
        holder.getAnimationItemBinding().aiFavorite.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.animation.presentation.adapter.AnimationAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnimationAdapter.onBindViewHolder$lambda$3(AnimationAdapter.this, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(AnimationAdapter animationAdapter, int i, AnimationHolder animationHolder, View view) {
        OnAnimationClickListener onAnimationClickListener;
        Object obj;
        Iterator<T> it = animationAdapter.animationList.iterator();
        while (true) {
            onAnimationClickListener = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Animation) obj).isEnabled()) {
                break;
            }
        }
        Animation animation = (Animation) obj;
        if (animation != null) {
            animation.setEnabled(false);
            animationAdapter.notifyItemChanged(animationAdapter.animationList.indexOf(animation));
        }
        animationAdapter.animationList.get(i).setEnabled(true);
        LinearLayout linearLayout = animationHolder.getAnimationItemBinding().aiBackground;
        Context context = animationAdapter.context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        linearLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.ic_animation_item_enabled_bg));
        OnAnimationClickListener onAnimationClickListener2 = animationAdapter.onAnimationClickListener;
        if (onAnimationClickListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onAnimationClickListener");
        } else {
            onAnimationClickListener = onAnimationClickListener2;
        }
        Animation animation2 = animationAdapter.animationList.get(i);
        Intrinsics.checkNotNullExpressionValue(animation2, "get(...)");
        onAnimationClickListener.callback(animation2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3(AnimationAdapter animationAdapter, int i, View view) {
        if (animationAdapter.animationList.get(i).getFavorited() == 0) {
            animationAdapter.sendServerEvent.clickedWrapper(UIElementID.ANIMATION_MENU.getId(), animationAdapter.animationList.get(i).getId(), 2);
        } else {
            animationAdapter.sendServerEvent.clickedWrapper(UIElementID.ANIMATION_MENU.getId(), animationAdapter.animationList.get(i).getId(), 3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(AnimationHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled((AnimationAdapter) holder);
        AppCompatImageView appCompatImageView = holder.getAnimationItemBinding().aiFavorite;
        Context context = this.context;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        appCompatImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_favorites_disabled));
        LinearLayout linearLayout = holder.getAnimationItemBinding().aiBackground;
        Context context3 = this.context;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        } else {
            context2 = context3;
        }
        linearLayout.setBackground(ContextCompat.getDrawable(context2, R.drawable.ic_item_bg));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.animationList.size();
    }

    public final void changeFavouriteStatus(AnimationFavourites animationFavourites) {
        Intrinsics.checkNotNullParameter(animationFavourites, "animationFavourites");
        int i = 0;
        for (Object obj : this.animationList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Animation animation = (Animation) obj;
            if (animationFavourites.getId() == animation.getId()) {
                animation.setFavorited(animationFavourites.getFavorited());
                notifyDataSetChanged();
            }
            i = i2;
        }
    }

    public final void addAnimations(List<Animation> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.animationList.clear();
        this.animationList.addAll(data);
        notifyDataSetChanged();
    }
}
