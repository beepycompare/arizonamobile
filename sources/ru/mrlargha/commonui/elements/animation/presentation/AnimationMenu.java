package ru.mrlargha.commonui.elements.animation.presentation;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.AnimationMenuBinding;
import ru.mrlargha.commonui.elements.animation.domain.obj.Animation;
import ru.mrlargha.commonui.elements.animation.domain.obj.AnimationCategory;
import ru.mrlargha.commonui.elements.animation.domain.obj.AnimationFavourites;
import ru.mrlargha.commonui.elements.animation.presentation.adapter.AnimationAdapter;
import ru.mrlargha.commonui.elements.animation.presentation.adapter.AnimationCategoryAdapter;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: AnimationMenu.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0005H\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lru/mrlargha/commonui/elements/animation/presentation/AnimationMenu;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "animationMenu", "Landroid/view/View;", "kotlin.jvm.PlatformType", "animationMenuBinding", "Lru/mrlargha/commonui/databinding/AnimationMenuBinding;", "animationCategoryAdapter", "Lru/mrlargha/commonui/elements/animation/presentation/adapter/AnimationCategoryAdapter;", "animationAdapter", "Lru/mrlargha/commonui/elements/animation/presentation/adapter/AnimationAdapter;", "animationList", "Ljava/util/ArrayList;", "Lru/mrlargha/commonui/elements/animation/domain/obj/Animation;", "Lkotlin/collections/ArrayList;", "addAnimations", "", "data", "", "addAnimationCategories", "addToFavourites", "onBackendMessage", "subId", "Companion", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnimationMenu extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "AnimationMenu";
    private final AnimationAdapter animationAdapter;
    private final AnimationCategoryAdapter animationCategoryAdapter;
    private final ArrayList<Animation> animationList;
    private final View animationMenu;
    private final AnimationMenuBinding animationMenuBinding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimationMenu(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View animationMenu = targetActivity.getLayoutInflater().inflate(R.layout.animation_menu, (ViewGroup) null);
        this.animationMenu = animationMenu;
        AnimationMenuBinding bind = AnimationMenuBinding.bind(animationMenu);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.animationMenuBinding = bind;
        AnimationCategoryAdapter animationCategoryAdapter = new AnimationCategoryAdapter();
        this.animationCategoryAdapter = animationCategoryAdapter;
        AnimationAdapter animationAdapter = new AnimationAdapter(targetActivity);
        this.animationAdapter = animationAdapter;
        this.animationList = new ArrayList<>();
        Intrinsics.checkNotNullExpressionValue(animationMenu, "animationMenu");
        addViewToConstraintLayout(animationMenu, -1, -1);
        setVisibility(false);
        EditText animationSearch = bind.animationSearch;
        Intrinsics.checkNotNullExpressionValue(animationSearch, "animationSearch");
        animationSearch.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.commonui.elements.animation.presentation.AnimationMenu$special$$inlined$doOnTextChanged$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                Object obj;
                if (charSequence != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = AnimationMenu.this.animationCategoryAdapter.getAnimationCategoryList().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (((AnimationCategory) obj).isEnabled()) {
                            break;
                        }
                    }
                    AnimationCategory animationCategory = (AnimationCategory) obj;
                    if (animationCategory != null) {
                        ArrayList<Animation> arrayList2 = new ArrayList();
                        for (Object obj2 : AnimationMenu.this.animationList) {
                            int categoryId = ((Animation) obj2).getCategoryId();
                            Integer id = animationCategory.getId();
                            if (id != null && categoryId == id.intValue()) {
                                arrayList2.add(obj2);
                            }
                        }
                        for (Animation animation : arrayList2) {
                            if (StringsKt.startsWith((CharSequence) animation.getName(), charSequence, true)) {
                                arrayList.add(animation);
                            }
                        }
                        AnimationMenu.this.animationAdapter.addAnimations(arrayList);
                    }
                }
            }
        });
        animationCategoryAdapter.setOnCategoryClickListener(new AnimationCategoryAdapter.OnCategoryClickListener() { // from class: ru.mrlargha.commonui.elements.animation.presentation.AnimationMenu.2
            @Override // ru.mrlargha.commonui.elements.animation.presentation.adapter.AnimationCategoryAdapter.OnCategoryClickListener
            public void callback(int i2) {
                List<AnimationCategory> animationCategoryList = AnimationMenu.this.animationCategoryAdapter.getAnimationCategoryList();
                if (Intrinsics.areEqual(animationCategoryList.get(i2).getName(), "Избранное")) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : AnimationMenu.this.animationList) {
                        if (((Animation) obj).getFavorited() == 1) {
                            arrayList.add(obj);
                        }
                    }
                    AnimationMenu.this.animationAdapter.addAnimations(arrayList);
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : AnimationMenu.this.animationList) {
                    int categoryId = ((Animation) obj2).getCategoryId();
                    Integer id = animationCategoryList.get(i2).getId();
                    if (id != null && categoryId == id.intValue()) {
                        arrayList2.add(obj2);
                    }
                }
                AnimationMenu.this.animationAdapter.addAnimations(arrayList2);
            }
        });
        animationAdapter.setOnAnimationClickListener(new AnimationAdapter.OnAnimationClickListener() { // from class: ru.mrlargha.commonui.elements.animation.presentation.AnimationMenu.3
            @Override // ru.mrlargha.commonui.elements.animation.presentation.adapter.AnimationAdapter.OnAnimationClickListener
            public void callback(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                AnimationMenu.this.getNotifier().clickedWrapper(UIElementID.ANIMATION_MENU.getId(), animation.getId(), 0);
            }
        });
        bind.amExitButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.animation.presentation.AnimationMenu$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnimationMenu._init_$lambda$6(AnimationMenu.this, view);
            }
        });
        bind.categoryList.setAdapter(animationCategoryAdapter);
        bind.animationList.setAdapter(animationAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$6(AnimationMenu animationMenu, View view) {
        animationMenu.getNotifier().clickedWrapper(UIElementID.ANIMATION_MENU.getId(), 0, 1);
        animationMenu.getNotifier().requestRemoveUIElement(animationMenu);
    }

    private final void addAnimations(String str) {
        List<Animation> listModel = MapperKt.toListModel(str, Animation.class);
        this.animationList.addAll(listModel);
        this.animationAdapter.addAnimations(listModel);
    }

    private final void addAnimationCategories(String str) {
        this.animationCategoryAdapter.addCategories(MapperKt.toListModel(str, AnimationCategory.class));
        this.animationCategoryAdapter.notifyDataSetChanged();
    }

    private final void addToFavourites(String str) {
        AnimationFavourites animationFavourites = (AnimationFavourites) MapperKt.jsonToModel(str, AnimationFavourites.class, getBackendID(), getTargetActivity(), getNotifier());
        for (Animation animation : this.animationList) {
            if (animationFavourites != null && animation.getId() == animationFavourites.getId()) {
                animation.setFavorited(animationFavourites.getFavorited());
            }
        }
        if (animationFavourites != null) {
            this.animationAdapter.changeFavouriteStatus(animationFavourites);
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            addAnimationCategories(data);
        } else if (i == 1) {
            addAnimations(data);
        } else if (i == 2) {
            addToFavourites(data);
        } else {
            Log.w(TAG, "Incorrect SUB_ID=" + i + ", msg=" + data);
        }
    }

    /* compiled from: AnimationMenu.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/animation/presentation/AnimationMenu$Companion;", "", "<init>", "()V", "TAG", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: AnimationMenu.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/animation/presentation/AnimationMenu$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new AnimationMenu(targetActivity, i);
        }
    }
}
