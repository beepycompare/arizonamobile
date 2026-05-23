package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.BackEventCompat;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationCoordinator;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.FadeThroughUpdateListener;
import com.google.android.material.internal.MultiViewUpdateListener;
import com.google.android.material.internal.RectEvaluator;
import com.google.android.material.internal.ReversableAnimatedValueInterpolator;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialMainContainerBackHelper;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.search.SearchView;
import com.google.android.material.search.SearchViewAnimationHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class SearchViewAnimationHelper {
    private static final float CONTENT_FROM_SCALE = 0.95f;
    private static final int DEFAULT_DURATION_MS = 100;
    private static final TimeInterpolator DEFAULT_INTERPOLATOR = AnimationUtils.LINEAR_INTERPOLATOR;
    private static final long HIDE_CLEAR_BUTTON_ALPHA_DURATION_MS = 42;
    private static final long HIDE_CLEAR_BUTTON_ALPHA_START_DELAY_MS = 0;
    private static final long HIDE_CONTENT_ALPHA_DURATION_MS = 83;
    private static final long HIDE_CONTENT_ALPHA_START_DELAY_MS = 0;
    private static final long HIDE_CONTENT_SCALE_DURATION_MS = 250;
    private static final long HIDE_DURATION_MS = 250;
    private static final long HIDE_TRANSLATE_DURATION_MS = 300;
    private static final long SHOW_CLEAR_BUTTON_ALPHA_DURATION_MS = 50;
    private static final long SHOW_CLEAR_BUTTON_ALPHA_START_DELAY_MS = 250;
    private static final long SHOW_CONTENT_ALPHA_DURATION_MS = 150;
    private static final long SHOW_CONTENT_ALPHA_START_DELAY_MS = 75;
    private static final long SHOW_CONTENT_SCALE_DURATION_MS = 300;
    private static final long SHOW_DURATION_MS = 300;
    private static final long SHOW_SCRIM_ALPHA_DURATION_MS = 100;
    private static final long SHOW_TRANSLATE_DURATION_MS = 350;
    private static final long SHOW_TRANSLATE_KEYBOARD_START_DELAY_MS = 150;
    AnimationCoordinator activeCoordinator;
    AnimatorSet activeTranslateAnimatorSet;
    final AnimationDelegate animationDelegate;
    private final MaterialMainContainerBackHelper backHelper;
    private AnimatorSet backProgressAnimatorSet;
    private final View backgroundView;
    private final ImageButton clearButton;
    private final TouchObserverFrameLayout contentContainer;
    private final Context context;
    private final View divider;
    private final TextView dummyTextView;
    private final Toolbar dummyToolbar;
    private final int durationShort1;
    private final int durationShort2;
    private final EditText editText;
    private final FrameLayout headerContainer;
    private final ClippableRoundedCornerLayout rootView;
    private final View scrim;
    private SearchBar searchBar;
    private final TextView searchPrefix;
    private final SearchView searchView;
    private final TimeInterpolator standardAccelerateInterpolator;
    private final TimeInterpolator standardDecelerateInterpolator;
    private final Toolbar toolbar;
    private final FrameLayout toolbarContainer;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface AnimationDelegate {
        AnimatorSet getExpandCollapseAnimatorSet(boolean z);

        List<SpringAnimation> getExpandCollapseSpringAnimations(boolean z);

        void onAnimationEnd(boolean z);

        void onAnimationStart(boolean z);

        void setUpDummyToolbarIfNeeded();

        void startButtonsTranslationAnimation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SearchViewAnimationHelper(Context context, SearchView searchView, boolean z) {
        AnimationDelegate defaultAnimationDelegate;
        this.context = context;
        this.searchView = searchView;
        this.scrim = searchView.scrim;
        this.backgroundView = searchView.backgroundView;
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = searchView.rootView;
        this.rootView = clippableRoundedCornerLayout;
        this.headerContainer = searchView.headerContainer;
        this.toolbarContainer = searchView.toolbarContainer;
        this.toolbar = searchView.toolbar;
        this.dummyToolbar = searchView.dummyToolbar;
        this.searchPrefix = searchView.searchPrefix;
        this.dummyTextView = searchView.dummyTextView;
        this.editText = searchView.editText;
        this.clearButton = searchView.clearButton;
        this.divider = searchView.divider;
        this.contentContainer = searchView.contentContainer;
        this.backHelper = new MaterialMainContainerBackHelper(clippableRoundedCornerLayout);
        int i = R.attr.motionEasingStandardAccelerateInterpolator;
        TimeInterpolator timeInterpolator = DEFAULT_INTERPOLATOR;
        this.standardAccelerateInterpolator = MotionUtils.resolveThemeInterpolator(context, i, timeInterpolator);
        this.standardDecelerateInterpolator = MotionUtils.resolveThemeInterpolator(context, R.attr.motionEasingStandardDecelerateInterpolator, timeInterpolator);
        this.durationShort1 = MotionUtils.resolveThemeDuration(context, R.attr.motionDurationShort1, 100);
        this.durationShort2 = MotionUtils.resolveThemeDuration(context, R.attr.motionDurationShort2, 100);
        if (z) {
            defaultAnimationDelegate = new ContainedAnimationDelegate();
        } else {
            defaultAnimationDelegate = new DefaultAnimationDelegate();
        }
        this.animationDelegate = defaultAnimationDelegate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSearchBar(SearchBar searchBar) {
        this.searchBar = searchBar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void show() {
        cancelPendingAnimations();
        if (this.searchBar != null) {
            startShowAnimationExpand();
        } else {
            startShowAnimationTranslate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimatorSet hide() {
        cancelPendingAnimations();
        if (this.searchBar != null) {
            return startHideAnimationCollapse();
        }
        return startHideAnimationTranslate();
    }

    void cancelPendingAnimations() {
        AnimationCoordinator animationCoordinator = this.activeCoordinator;
        if (animationCoordinator != null) {
            animationCoordinator.clear();
            this.activeCoordinator = null;
        }
        AnimatorSet animatorSet = this.activeTranslateAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.activeTranslateAnimatorSet = null;
        }
    }

    private void startShowAnimationExpand() {
        if (this.searchView.isAdjustNothingSoftInputMode()) {
            this.searchView.requestFocusAndShowKeyboardIfNeeded();
        }
        this.searchView.setTransitionState(SearchView.TransitionState.SHOWING);
        this.animationDelegate.setUpDummyToolbarIfNeeded();
        this.editText.setText(this.searchBar.getText());
        EditText editText = this.editText;
        editText.setSelection(editText.getText().length());
        this.rootView.setVisibility(4);
        this.rootView.post(new Runnable() { // from class: com.google.android.material.search.SearchViewAnimationHelper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SearchViewAnimationHelper.this.m9545x94743afc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startShowAnimationExpand$0$com-google-android-material-search-SearchViewAnimationHelper  reason: not valid java name */
    public /* synthetic */ void m9545x94743afc() {
        final AnimationCoordinator animationCoordinator = new AnimationCoordinator();
        animationCoordinator.addAnimator(getExpandCollapseAnimatorSet(true));
        for (SpringAnimation springAnimation : getExpandCollapseSpringAnimations(true)) {
            animationCoordinator.addDynamicAnimation(springAnimation);
        }
        animationCoordinator.addListener(new AnimationCoordinator.Listener() { // from class: com.google.android.material.search.SearchViewAnimationHelper.1
            @Override // com.google.android.material.animation.AnimationCoordinator.Listener
            public void onAnimationsStart() {
                SearchViewAnimationHelper.this.animationDelegate.onAnimationStart(r2);
                SearchViewAnimationHelper.this.rootView.setVisibility(0);
                SearchViewAnimationHelper.this.searchBar.stopOnLoadAnimation();
            }

            @Override // com.google.android.material.animation.AnimationCoordinator.Listener
            public void onAnimationsEnd() {
                SearchViewAnimationHelper.this.animationDelegate.onAnimationEnd(r2);
                if (!SearchViewAnimationHelper.this.searchView.isAdjustNothingSoftInputMode()) {
                    SearchViewAnimationHelper.this.searchView.requestFocusAndShowKeyboardIfNeeded();
                }
                SearchViewAnimationHelper.this.searchView.setTransitionState(SearchView.TransitionState.SHOWN);
                if (SearchViewAnimationHelper.this.activeCoordinator == animationCoordinator) {
                    SearchViewAnimationHelper.this.activeCoordinator = null;
                }
            }
        });
        animationCoordinator.start();
        this.activeCoordinator = animationCoordinator;
    }

    private AnimatorSet startHideAnimationCollapse() {
        if (this.searchView.isAdjustNothingSoftInputMode()) {
            this.editText.clearFocus();
        }
        final AnimationCoordinator animationCoordinator = new AnimationCoordinator();
        AnimatorSet expandCollapseAnimatorSet = getExpandCollapseAnimatorSet(false);
        animationCoordinator.addAnimator(expandCollapseAnimatorSet);
        for (SpringAnimation springAnimation : getExpandCollapseSpringAnimations(false)) {
            animationCoordinator.addDynamicAnimation(springAnimation);
        }
        animationCoordinator.addListener(new AnimationCoordinator.Listener() { // from class: com.google.android.material.search.SearchViewAnimationHelper.2
            @Override // com.google.android.material.animation.AnimationCoordinator.Listener
            public void onAnimationsStart() {
                SearchViewAnimationHelper.this.animationDelegate.onAnimationStart(r2);
                SearchViewAnimationHelper.this.searchView.setTransitionState(SearchView.TransitionState.HIDING);
            }

            @Override // com.google.android.material.animation.AnimationCoordinator.Listener
            public void onAnimationsEnd() {
                SearchViewAnimationHelper.this.animationDelegate.onAnimationEnd(r2);
                SearchViewAnimationHelper.this.rootView.setVisibility(8);
                if (!SearchViewAnimationHelper.this.searchView.isAdjustNothingSoftInputMode()) {
                    SearchViewAnimationHelper.this.editText.clearFocus();
                }
                SearchViewAnimationHelper.this.searchView.setTransitionState(SearchView.TransitionState.HIDDEN);
                if (SearchViewAnimationHelper.this.activeCoordinator == animationCoordinator) {
                    SearchViewAnimationHelper.this.activeCoordinator = null;
                }
            }
        });
        animationCoordinator.start();
        this.activeCoordinator = animationCoordinator;
        return expandCollapseAnimatorSet;
    }

    private void startShowAnimationTranslate() {
        if (this.searchView.isAdjustNothingSoftInputMode()) {
            final SearchView searchView = this.searchView;
            Objects.requireNonNull(searchView);
            searchView.postDelayed(new Runnable() { // from class: com.google.android.material.search.SearchViewAnimationHelper$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    SearchView.this.requestFocusAndShowKeyboardIfNeeded();
                }
            }, 150L);
        }
        this.rootView.setVisibility(4);
        this.rootView.post(new Runnable() { // from class: com.google.android.material.search.SearchViewAnimationHelper$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                SearchViewAnimationHelper.this.m9546x4df249eb();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startShowAnimationTranslate$1$com-google-android-material-search-SearchViewAnimationHelper  reason: not valid java name */
    public /* synthetic */ void m9546x4df249eb() {
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.rootView;
        clippableRoundedCornerLayout.setTranslationY(clippableRoundedCornerLayout.getHeight());
        final AnimatorSet translateAnimatorSet = getTranslateAnimatorSet(true);
        translateAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.search.SearchViewAnimationHelper.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SearchViewAnimationHelper.this.rootView.setVisibility(0);
                SearchViewAnimationHelper.this.searchView.setTransitionState(SearchView.TransitionState.SHOWING);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!SearchViewAnimationHelper.this.searchView.isAdjustNothingSoftInputMode()) {
                    SearchViewAnimationHelper.this.searchView.requestFocusAndShowKeyboardIfNeeded();
                }
                SearchViewAnimationHelper.this.searchView.setTransitionState(SearchView.TransitionState.SHOWN);
                if (SearchViewAnimationHelper.this.activeTranslateAnimatorSet == translateAnimatorSet) {
                    SearchViewAnimationHelper.this.activeTranslateAnimatorSet = null;
                }
            }
        });
        translateAnimatorSet.start();
        this.activeTranslateAnimatorSet = translateAnimatorSet;
    }

    private AnimatorSet startHideAnimationTranslate() {
        if (this.searchView.isAdjustNothingSoftInputMode()) {
            this.editText.clearFocus();
        }
        final AnimatorSet translateAnimatorSet = getTranslateAnimatorSet(false);
        translateAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.search.SearchViewAnimationHelper.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SearchViewAnimationHelper.this.searchView.setTransitionState(SearchView.TransitionState.HIDING);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SearchViewAnimationHelper.this.rootView.setVisibility(8);
                if (!SearchViewAnimationHelper.this.searchView.isAdjustNothingSoftInputMode()) {
                    SearchViewAnimationHelper.this.editText.clearFocus();
                }
                SearchViewAnimationHelper.this.searchView.setTransitionState(SearchView.TransitionState.HIDDEN);
                if (SearchViewAnimationHelper.this.activeTranslateAnimatorSet == translateAnimatorSet) {
                    SearchViewAnimationHelper.this.activeTranslateAnimatorSet = null;
                }
            }
        });
        translateAnimatorSet.start();
        this.activeTranslateAnimatorSet = translateAnimatorSet;
        return translateAnimatorSet;
    }

    private AnimatorSet getTranslateAnimatorSet(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(getTranslationYAnimator());
        addBackButtonProgressAnimatorIfNeeded(animatorSet);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        animatorSet.setDuration(z ? SHOW_TRANSLATE_DURATION_MS : 300L);
        return animatorSet;
    }

    private Animator getTranslationYAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.rootView.getHeight(), 0.0f);
        ofFloat.addUpdateListener(MultiViewUpdateListener.translationYListener(this.rootView));
        return ofFloat;
    }

    private AnimatorSet getExpandCollapseAnimatorSet(boolean z) {
        AnimatorSet expandCollapseAnimatorSet = this.animationDelegate.getExpandCollapseAnimatorSet(z);
        if (this.backProgressAnimatorSet == null) {
            expandCollapseAnimatorSet.playTogether(getButtonsProgressAnimator(z));
        }
        return expandCollapseAnimatorSet;
    }

    private List<SpringAnimation> getExpandCollapseSpringAnimations(boolean z) {
        return this.animationDelegate.getExpandCollapseSpringAnimations(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator getClearButtonAnimator(boolean z) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(z ? 50L : HIDE_CLEAR_BUTTON_ALPHA_DURATION_MS);
        ofFloat.setStartDelay(z ? 250L : 0L);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.LINEAR_INTERPOLATOR));
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(this.clearButton));
        return ofFloat;
    }

    private AnimatorSet getButtonsProgressAnimator(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        addBackButtonProgressAnimatorIfNeeded(animatorSet);
        animatorSet.setDuration(z ? 300L : 250L);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return animatorSet;
    }

    private void addBackButtonProgressAnimatorIfNeeded(AnimatorSet animatorSet) {
        ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(this.toolbar);
        if (navigationIconButton == null) {
            return;
        }
        Drawable unwrap = DrawableCompat.unwrap(navigationIconButton.getDrawable());
        if (this.searchView.isAnimatedNavigationIcon()) {
            addDrawerArrowDrawableAnimatorIfNeeded(animatorSet, unwrap);
            addFadeThroughDrawableAnimatorIfNeeded(animatorSet, unwrap);
            addBackButtonAnimatorIfNeeded(animatorSet, navigationIconButton);
            return;
        }
        setFullDrawableProgressIfNeeded(unwrap);
    }

    private void addBackButtonAnimatorIfNeeded(AnimatorSet animatorSet, final ImageButton imageButton) {
        SearchBar searchBar = this.searchBar;
        if (searchBar == null || searchBar.getNavigationIcon() != null) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.SearchViewAnimationHelper$$ExternalSyntheticLambda5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                imageButton.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        animatorSet.playTogether(ofFloat);
    }

    private void addDrawerArrowDrawableAnimatorIfNeeded(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof DrawerArrowDrawable) {
            final DrawerArrowDrawable drawerArrowDrawable = (DrawerArrowDrawable) drawable;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.SearchViewAnimationHelper$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DrawerArrowDrawable.this.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            animatorSet.playTogether(ofFloat);
        }
    }

    private void addFadeThroughDrawableAnimatorIfNeeded(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof FadeThroughDrawable) {
            final FadeThroughDrawable fadeThroughDrawable = (FadeThroughDrawable) drawable;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.SearchViewAnimationHelper$$ExternalSyntheticLambda2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FadeThroughDrawable.this.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            animatorSet.playTogether(ofFloat);
        }
    }

    private void setFullDrawableProgressIfNeeded(Drawable drawable) {
        if (drawable instanceof DrawerArrowDrawable) {
            ((DrawerArrowDrawable) drawable).setProgress(1.0f);
        }
        if (drawable instanceof FadeThroughDrawable) {
            ((FadeThroughDrawable) drawable).setProgress(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldInflateDummyToolbar() {
        return this.searchBar.getMenuResId() != -1 && this.searchView.isMenuItemsAnimated() && hasVisibleMenuItems(this.searchBar.getMenu());
    }

    private boolean hasVisibleMenuItems(Menu menu) {
        if (menu == null) {
            return false;
        }
        for (int i = 0; i < menu.size(); i++) {
            if (menu.getItem(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMenuItemsNotClickable(Toolbar toolbar) {
        ActionMenuView actionMenuView = ToolbarUtils.getActionMenuView(toolbar);
        if (actionMenuView != null) {
            for (int i = 0; i < actionMenuView.getChildCount(); i++) {
                View childAt = actionMenuView.getChildAt(i);
                childAt.setClickable(false);
                childAt.setFocusable(false);
                childAt.setFocusableInTouchMode(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startBackProgress(BackEventCompat backEventCompat) {
        this.backHelper.startBackProgress(backEventCompat, this.searchBar);
    }

    public void updateBackProgress(BackEventCompat backEventCompat) {
        if (backEventCompat.getProgress() <= 0.0f) {
            return;
        }
        MaterialMainContainerBackHelper materialMainContainerBackHelper = this.backHelper;
        SearchBar searchBar = this.searchBar;
        materialMainContainerBackHelper.updateBackProgress(backEventCompat, searchBar, searchBar.getCornerSize());
        AnimatorSet animatorSet = this.backProgressAnimatorSet;
        if (animatorSet == null) {
            if (this.searchView.isAdjustNothingSoftInputMode()) {
                this.editText.clearFocus();
            }
            if (this.searchView.isAnimatedNavigationIcon()) {
                AnimatorSet buttonsProgressAnimator = getButtonsProgressAnimator(false);
                this.backProgressAnimatorSet = buttonsProgressAnimator;
                buttonsProgressAnimator.start();
                this.backProgressAnimatorSet.pause();
                return;
            }
            return;
        }
        animatorSet.setCurrentPlayTime(backEventCompat.getProgress() * ((float) this.backProgressAnimatorSet.getDuration()));
    }

    public BackEventCompat onHandleBackInvoked() {
        return this.backHelper.onHandleBackInvoked();
    }

    public void finishBackProgress() {
        this.backHelper.finishBackProgress(hide().getTotalDuration(), this.searchBar);
        if (this.backProgressAnimatorSet != null) {
            this.animationDelegate.startButtonsTranslationAnimation();
            this.backProgressAnimatorSet.resume();
        }
        this.backProgressAnimatorSet = null;
    }

    public void cancelBackProgress() {
        this.backHelper.cancelBackProgress(this.searchBar);
        AnimatorSet animatorSet = this.backProgressAnimatorSet;
        if (animatorSet != null) {
            animatorSet.reverse();
        }
        this.backProgressAnimatorSet = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaterialMainContainerBackHelper getBackHelper() {
        return this.backHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackgroundAlpha(float f) {
        this.backgroundView.getBackground().mutate().setAlpha((int) (f * 255.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentViewsAlpha(float f) {
        this.clearButton.setAlpha(f);
        this.divider.setAlpha(f);
        this.contentContainer.setAlpha(f);
        setActionMenuViewAlphaIfNeeded(f);
    }

    private void setActionMenuViewAlphaIfNeeded(float f) {
        ActionMenuView actionMenuView;
        if (!this.searchView.isMenuItemsAnimated() || (actionMenuView = ToolbarUtils.getActionMenuView(this.toolbar)) == null) {
            return;
        }
        actionMenuView.setAlpha(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTranslationXBetweenViews(View view, View view2) {
        if (view == null) {
            int marginStart = ((ViewGroup.MarginLayoutParams) view2.getLayoutParams()).getMarginStart();
            int paddingStart = this.searchBar.getPaddingStart();
            int viewLeftFromSearchViewParent = getViewLeftFromSearchViewParent(this.searchBar);
            return ViewUtils.isLayoutRtl(this.searchBar) ? (((viewLeftFromSearchViewParent + this.searchBar.getWidth()) + marginStart) - paddingStart) - this.searchView.getRight() : (viewLeftFromSearchViewParent - marginStart) + paddingStart;
        }
        return getViewLeftFromSearchViewParent(view) - getViewLeftFromSearchViewParent(view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getViewLeftFromSearchViewParent(View view) {
        int left = view.getLeft();
        for (ViewParent parent = view.getParent(); (parent instanceof View) && parent != this.searchView.getParent(); parent = parent.getParent()) {
            left += ((View) parent).getLeft();
        }
        return left;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getViewTopFromSearchViewParent(View view) {
        int top = view.getTop();
        for (ViewParent parent = view.getParent(); (parent instanceof View) && parent != this.searchView.getParent(); parent = parent.getParent()) {
            top += ((View) parent).getTop();
        }
        return top;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class DefaultAnimationDelegate implements AnimationDelegate {
        private DefaultAnimationDelegate() {
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public void setUpDummyToolbarIfNeeded() {
            Menu menu = SearchViewAnimationHelper.this.dummyToolbar.getMenu();
            if (menu != null) {
                menu.clear();
            }
            boolean shouldInflateDummyToolbar = SearchViewAnimationHelper.this.shouldInflateDummyToolbar();
            SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
            if (shouldInflateDummyToolbar) {
                searchViewAnimationHelper.dummyToolbar.inflateMenu(SearchViewAnimationHelper.this.searchBar.getMenuResId());
                SearchViewAnimationHelper searchViewAnimationHelper2 = SearchViewAnimationHelper.this;
                searchViewAnimationHelper2.setMenuItemsNotClickable(searchViewAnimationHelper2.dummyToolbar);
                SearchViewAnimationHelper.this.dummyToolbar.setVisibility(0);
                return;
            }
            searchViewAnimationHelper.dummyToolbar.setVisibility(8);
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public AnimatorSet getExpandCollapseAnimatorSet(boolean z) {
            AnimatorSet animatorSet = new AnimatorSet();
            if (SearchViewAnimationHelper.this.backProgressAnimatorSet == null) {
                animatorSet.playTogether(getButtonsTranslationAnimator(z));
            }
            animatorSet.playTogether(getScrimAlphaAnimator(z), getRootViewAnimator(z), SearchViewAnimationHelper.this.getClearButtonAnimator(z), getContentAnimator(z), getHeaderContainerAnimator(z), getDummyToolbarAnimator(z), getActionMenuViewsAlphaAnimator(z), getEditTextAnimator(z), getSearchPrefixAnimator(z), getTextAnimator(z));
            return animatorSet;
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public List<SpringAnimation> getExpandCollapseSpringAnimations(boolean z) {
            return new ArrayList();
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public void onAnimationStart(boolean z) {
            SearchViewAnimationHelper.this.setContentViewsAlpha(z ? 0.0f : 1.0f);
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public void onAnimationEnd(boolean z) {
            SearchViewAnimationHelper.this.setContentViewsAlpha(z ? 1.0f : 0.0f);
            SearchViewAnimationHelper.this.editText.setAlpha(1.0f);
            if (SearchViewAnimationHelper.this.searchBar != null) {
                SearchViewAnimationHelper.this.searchBar.getTextView().setAlpha(1.0f);
            }
            SearchViewAnimationHelper.this.editText.setClipBounds(null);
            SearchViewAnimationHelper.this.rootView.resetClipBoundsAndCornerRadii();
            if (z) {
                return;
            }
            SearchViewAnimationHelper.this.backHelper.clearExpandedCornerRadii();
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public void startButtonsTranslationAnimation() {
            getButtonsTranslationAnimator(false).start();
        }

        private Animator getScrimAlphaAnimator(boolean z) {
            TimeInterpolator timeInterpolator = z ? AnimationUtils.LINEAR_INTERPOLATOR : AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(z ? 300L : 250L);
            ofFloat.setStartDelay(z ? SearchViewAnimationHelper.SHOW_SCRIM_ALPHA_DURATION_MS : 0L);
            ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z, timeInterpolator));
            ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(SearchViewAnimationHelper.this.scrim));
            return ofFloat;
        }

        private Animator getRootViewAnimator(boolean z) {
            Rect initialHideToClipBounds = SearchViewAnimationHelper.this.backHelper.getInitialHideToClipBounds();
            Rect initialHideFromClipBounds = SearchViewAnimationHelper.this.backHelper.getInitialHideFromClipBounds();
            if (initialHideToClipBounds == null) {
                initialHideToClipBounds = ViewUtils.calculateRectFromBounds(SearchViewAnimationHelper.this.searchView);
            }
            if (initialHideFromClipBounds == null) {
                initialHideFromClipBounds = ViewUtils.calculateOffsetRectFromBounds(SearchViewAnimationHelper.this.rootView, SearchViewAnimationHelper.this.searchBar);
            }
            final Rect rect = new Rect(initialHideFromClipBounds);
            final float cornerSize = SearchViewAnimationHelper.this.searchBar.getCornerSize();
            final float[] maxCornerRadii = maxCornerRadii(SearchViewAnimationHelper.this.rootView.getCornerRadii(), SearchViewAnimationHelper.this.backHelper.getExpandedCornerRadii());
            ValueAnimator ofObject = ValueAnimator.ofObject(new RectEvaluator(rect), initialHideFromClipBounds, initialHideToClipBounds);
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.SearchViewAnimationHelper$DefaultAnimationDelegate$$ExternalSyntheticLambda1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SearchViewAnimationHelper.DefaultAnimationDelegate.this.m9553x8b5d297b(cornerSize, maxCornerRadii, rect, valueAnimator);
                }
            });
            ofObject.setDuration(z ? 300L : 250L);
            ofObject.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            return ofObject;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$getRootViewAnimator$0$com-google-android-material-search-SearchViewAnimationHelper$DefaultAnimationDelegate  reason: not valid java name */
        public /* synthetic */ void m9553x8b5d297b(float f, float[] fArr, Rect rect, ValueAnimator valueAnimator) {
            SearchViewAnimationHelper.this.rootView.updateClipBoundsAndCornerRadii(rect, lerpCornerRadii(f, fArr, valueAnimator.getAnimatedFraction()));
        }

        private float[] maxCornerRadii(float[] fArr, float[] fArr2) {
            return new float[]{Math.max(fArr[0], fArr2[0]), Math.max(fArr[1], fArr2[1]), Math.max(fArr[2], fArr2[2]), Math.max(fArr[3], fArr2[3]), Math.max(fArr[4], fArr2[4]), Math.max(fArr[5], fArr2[5]), Math.max(fArr[6], fArr2[6]), Math.max(fArr[7], fArr2[7])};
        }

        private float[] lerpCornerRadii(float f, float[] fArr, float f2) {
            return new float[]{AnimationUtils.lerp(f, fArr[0], f2), AnimationUtils.lerp(f, fArr[1], f2), AnimationUtils.lerp(f, fArr[2], f2), AnimationUtils.lerp(f, fArr[3], f2), AnimationUtils.lerp(f, fArr[4], f2), AnimationUtils.lerp(f, fArr[5], f2), AnimationUtils.lerp(f, fArr[6], f2), AnimationUtils.lerp(f, fArr[7], f2)};
        }

        private Animator getDummyToolbarAnimator(boolean z) {
            return getTranslationAnimator(z, SearchViewAnimationHelper.this.dummyToolbar, getFromTranslationXEnd(SearchViewAnimationHelper.this.dummyToolbar) - (SearchViewAnimationHelper.this.searchBar.getPaddingEnd() - SearchViewAnimationHelper.this.dummyToolbar.getPaddingEnd()), getFromTranslationY());
        }

        private Animator getHeaderContainerAnimator(boolean z) {
            return getTranslationAnimator(z, SearchViewAnimationHelper.this.headerContainer, getFromTranslationXEnd(SearchViewAnimationHelper.this.headerContainer), getFromTranslationY());
        }

        private Animator getActionMenuViewsAlphaAnimator(boolean z) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(z ? 300L : 250L);
            ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            if (SearchViewAnimationHelper.this.searchView.isMenuItemsAnimated()) {
                ofFloat.addUpdateListener(new FadeThroughUpdateListener(ToolbarUtils.getActionMenuView(SearchViewAnimationHelper.this.dummyToolbar), ToolbarUtils.getActionMenuView(SearchViewAnimationHelper.this.toolbar)));
            }
            return ofFloat;
        }

        private Animator getSearchPrefixAnimator(boolean z) {
            return getTranslationAnimatorForText(z, SearchViewAnimationHelper.this.searchPrefix);
        }

        private Animator getEditTextAnimator(boolean z) {
            return getTranslationAnimatorForText(z, SearchViewAnimationHelper.this.editText);
        }

        private AnimatorSet getTextAnimator(boolean z) {
            AnimatorSet animatorSet = new AnimatorSet();
            addTextFadeAnimatorIfNeeded(animatorSet);
            addEditTextClipAnimator(animatorSet);
            animatorSet.setDuration(z ? 300L : 250L);
            animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.LINEAR_INTERPOLATOR));
            return animatorSet;
        }

        private void addEditTextClipAnimator(AnimatorSet animatorSet) {
            if (SearchViewAnimationHelper.this.searchBar == null || !TextUtils.equals(SearchViewAnimationHelper.this.editText.getText(), SearchViewAnimationHelper.this.searchBar.getText())) {
                return;
            }
            final Rect rect = new Rect(0, 0, SearchViewAnimationHelper.this.editText.getWidth(), SearchViewAnimationHelper.this.editText.getHeight());
            ValueAnimator ofInt = ValueAnimator.ofInt(SearchViewAnimationHelper.this.searchBar.getTextView().getWidth(), SearchViewAnimationHelper.this.editText.getWidth());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.SearchViewAnimationHelper$DefaultAnimationDelegate$$ExternalSyntheticLambda2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SearchViewAnimationHelper.DefaultAnimationDelegate.this.m9551xb169caa7(rect, valueAnimator);
                }
            });
            animatorSet.playTogether(ofInt);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$addEditTextClipAnimator$1$com-google-android-material-search-SearchViewAnimationHelper$DefaultAnimationDelegate  reason: not valid java name */
        public /* synthetic */ void m9551xb169caa7(Rect rect, ValueAnimator valueAnimator) {
            rect.right = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            SearchViewAnimationHelper.this.editText.setClipBounds(rect);
        }

        private void addTextFadeAnimatorIfNeeded(AnimatorSet animatorSet) {
            if (SearchViewAnimationHelper.this.searchBar == null || TextUtils.equals(SearchViewAnimationHelper.this.editText.getText(), SearchViewAnimationHelper.this.searchBar.getText())) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.SearchViewAnimationHelper$DefaultAnimationDelegate$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SearchViewAnimationHelper.DefaultAnimationDelegate.this.m9552x8539623c(valueAnimator);
                }
            });
            animatorSet.playTogether(ofFloat);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$addTextFadeAnimatorIfNeeded$2$com-google-android-material-search-SearchViewAnimationHelper$DefaultAnimationDelegate  reason: not valid java name */
        public /* synthetic */ void m9552x8539623c(ValueAnimator valueAnimator) {
            SearchViewAnimationHelper.this.editText.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            SearchViewAnimationHelper.this.searchBar.getTextView().setAlpha(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        private Animator getTranslationAnimatorForText(boolean z, View view) {
            TextView placeholderTextView = SearchViewAnimationHelper.this.searchBar.getPlaceholderTextView();
            if (TextUtils.isEmpty(placeholderTextView.getText()) || z) {
                placeholderTextView = SearchViewAnimationHelper.this.searchBar.getTextView();
            }
            int viewLeftFromSearchViewParent = SearchViewAnimationHelper.this.getViewLeftFromSearchViewParent(placeholderTextView) - SearchViewAnimationHelper.this.getViewLeftFromSearchViewParent(view);
            if (ViewUtils.isLayoutRtl(SearchViewAnimationHelper.this.searchBar)) {
                viewLeftFromSearchViewParent += placeholderTextView.getWidth() - view.getWidth();
            }
            return getTranslationAnimator(z, view, viewLeftFromSearchViewParent, getFromTranslationY());
        }

        private Animator getContentAnimator(boolean z) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(getContentAlphaAnimator(z), getDividerAnimator(z), getContentScaleAnimator(z));
            return animatorSet;
        }

        private Animator getContentAlphaAnimator(boolean z) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(z ? 150L : SearchViewAnimationHelper.HIDE_CONTENT_ALPHA_DURATION_MS);
            ofFloat.setStartDelay(z ? 75L : 0L);
            ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.LINEAR_INTERPOLATOR));
            ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(SearchViewAnimationHelper.this.divider, SearchViewAnimationHelper.this.contentContainer));
            return ofFloat;
        }

        private Animator getDividerAnimator(boolean z) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat((SearchViewAnimationHelper.this.contentContainer.getHeight() * 0.050000012f) / 2.0f, 0.0f);
            ofFloat.setDuration(z ? 300L : 250L);
            ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            ofFloat.addUpdateListener(MultiViewUpdateListener.translationYListener(SearchViewAnimationHelper.this.divider));
            return ofFloat;
        }

        private Animator getContentScaleAnimator(boolean z) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(SearchViewAnimationHelper.CONTENT_FROM_SCALE, 1.0f);
            ofFloat.setDuration(z ? 300L : 250L);
            ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            ofFloat.addUpdateListener(MultiViewUpdateListener.scaleListener(SearchViewAnimationHelper.this.contentContainer));
            return ofFloat;
        }

        private Animator getTranslationAnimator(boolean z, View view, int i, int i2) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i, 0.0f);
            ofFloat.addUpdateListener(MultiViewUpdateListener.translationXListener(view));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(i2, 0.0f);
            ofFloat2.addUpdateListener(MultiViewUpdateListener.translationYListener(view));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.setDuration(z ? 300L : 250L);
            animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            return animatorSet;
        }

        private int getFromTranslationXEnd(View view) {
            int marginEnd = ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).getMarginEnd();
            SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
            int viewLeftFromSearchViewParent = searchViewAnimationHelper.getViewLeftFromSearchViewParent(searchViewAnimationHelper.searchBar);
            return ViewUtils.isLayoutRtl(SearchViewAnimationHelper.this.searchBar) ? viewLeftFromSearchViewParent - marginEnd : ((viewLeftFromSearchViewParent + SearchViewAnimationHelper.this.searchBar.getWidth()) + marginEnd) - SearchViewAnimationHelper.this.searchView.getWidth();
        }

        private int getFromTranslationY() {
            int top = SearchViewAnimationHelper.this.toolbarContainer.getTop() + (SearchViewAnimationHelper.this.toolbarContainer.getHeight() / 2);
            SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
            return (searchViewAnimationHelper.getViewTopFromSearchViewParent(searchViewAnimationHelper.searchBar) + (SearchViewAnimationHelper.this.searchBar.getHeight() / 2)) - top;
        }

        private AnimatorSet getButtonsTranslationAnimator(boolean z) {
            AnimatorSet animatorSet = new AnimatorSet();
            addBackButtonTranslationAnimatorIfNeeded(animatorSet);
            addActionMenuViewAnimatorIfNeeded(animatorSet);
            animatorSet.setDuration(z ? 300L : 250L);
            animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            return animatorSet;
        }

        private void addBackButtonTranslationAnimatorIfNeeded(AnimatorSet animatorSet) {
            ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(SearchViewAnimationHelper.this.toolbar);
            if (navigationIconButton == null) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(SearchViewAnimationHelper.this.getTranslationXBetweenViews(ToolbarUtils.getNavigationIconButton(SearchViewAnimationHelper.this.searchBar), navigationIconButton), 0.0f);
            ofFloat.addUpdateListener(MultiViewUpdateListener.translationXListener(navigationIconButton));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(getFromTranslationY(), 0.0f);
            ofFloat2.addUpdateListener(MultiViewUpdateListener.translationYListener(navigationIconButton));
            animatorSet.playTogether(ofFloat, ofFloat2);
        }

        private void addActionMenuViewAnimatorIfNeeded(AnimatorSet animatorSet) {
            ActionMenuView actionMenuView = ToolbarUtils.getActionMenuView(SearchViewAnimationHelper.this.toolbar);
            if (actionMenuView == null) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(SearchViewAnimationHelper.this.getTranslationXBetweenViews(ToolbarUtils.getActionMenuView(SearchViewAnimationHelper.this.searchBar), actionMenuView), 0.0f);
            ofFloat.addUpdateListener(MultiViewUpdateListener.translationXListener(actionMenuView));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(getFromTranslationY(), 0.0f);
            ofFloat2.addUpdateListener(MultiViewUpdateListener.translationYListener(actionMenuView));
            animatorSet.playTogether(ofFloat, ofFloat2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class ContainedAnimationDelegate implements AnimationDelegate {
        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public void startButtonsTranslationAnimation() {
        }

        ContainedAnimationDelegate() {
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public void setUpDummyToolbarIfNeeded() {
            setUpDummyTextViewIfNeeded();
            if (SearchViewAnimationHelper.this.searchBar.getBackground() != null && SearchViewAnimationHelper.this.searchBar.getBackground().getConstantState() != null) {
                SearchViewAnimationHelper.this.dummyToolbar.setBackground(SearchViewAnimationHelper.this.searchBar.getBackground().getConstantState().newDrawable());
            }
            Menu menu = SearchViewAnimationHelper.this.dummyToolbar.getMenu();
            if (menu != null) {
                menu.clear();
            }
            if (SearchViewAnimationHelper.this.shouldInflateDummyToolbar()) {
                SearchViewAnimationHelper.this.dummyToolbar.inflateMenu(SearchViewAnimationHelper.this.searchBar.getMenuResId());
                SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
                searchViewAnimationHelper.setMenuItemsNotClickable(searchViewAnimationHelper.dummyToolbar);
            }
        }

        private void setUpDummyTextViewIfNeeded() {
            TextView textView = SearchViewAnimationHelper.this.searchBar.getTextView();
            SearchViewAnimationHelper.this.dummyTextView.setText(textView.getText());
            SearchViewAnimationHelper.this.dummyTextView.setHint(textView.getHint());
            SearchViewAnimationHelper.this.dummyTextView.setVisibility(0);
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public AnimatorSet getExpandCollapseAnimatorSet(boolean z) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(getBackgroundAlphaAnimator(z), getContentAlphaAnimator(z), getToolbarAlphaAnimator(z), getDummyTextViewWidthAnimator(z), SearchViewAnimationHelper.this.getClearButtonAnimator(z), getSearchBarSiblingsTranslationAnimator(z));
            return animatorSet;
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public List<SpringAnimation> getExpandCollapseSpringAnimations(boolean z) {
            return Arrays.asList(getToolbarWidthSpringAnimation(z), getToolbarTranslationXSpringAnimation(z), getDummyToolbarWidthSpringAnimation(z), getDummyToolbarTranslationXSpringAnimation(z), getToolbarContainerTranslationYSpringAnimation(z), getEditTextTranslationXSpringAnimation(z), getDummyTextTranslationXSpringAnimation(z));
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public void onAnimationStart(boolean z) {
            SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
            if (z) {
                searchViewAnimationHelper.setBackgroundAlpha(0.0f);
                SearchViewAnimationHelper.this.toolbar.setAlpha(0.0f);
                SearchViewAnimationHelper.this.contentContainer.setAlpha(0.0f);
                SearchViewAnimationHelper.this.searchBar.setVisibility(4);
            } else {
                searchViewAnimationHelper.setBackgroundAlpha(1.0f);
                SearchViewAnimationHelper.this.contentContainer.setAlpha(1.0f);
            }
            SearchViewAnimationHelper.this.dummyToolbar.setVisibility(0);
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public void onAnimationEnd(boolean z) {
            SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
            if (z) {
                searchViewAnimationHelper.setBackgroundAlpha(1.0f);
                SearchViewAnimationHelper.this.contentContainer.setAlpha(1.0f);
            } else {
                searchViewAnimationHelper.setBackgroundAlpha(0.0f);
                SearchViewAnimationHelper.this.contentContainer.setAlpha(0.0f);
                SearchViewAnimationHelper.this.searchBar.setVisibility(0);
            }
            SearchViewAnimationHelper.this.dummyToolbar.setVisibility(4);
            setWidth(SearchViewAnimationHelper.this.dummyTextView, -2);
        }

        private Animator getBackgroundAlphaAnimator(boolean z) {
            ValueAnimator alphaValueAnimator = getAlphaValueAnimator(z);
            alphaValueAnimator.setDuration(SearchViewAnimationHelper.this.durationShort2);
            alphaValueAnimator.setStartDelay(z ? 0L : SearchViewAnimationHelper.this.durationShort1);
            SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
            alphaValueAnimator.setInterpolator(z ? searchViewAnimationHelper.standardDecelerateInterpolator : searchViewAnimationHelper.standardAccelerateInterpolator);
            alphaValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.SearchViewAnimationHelper$ContainedAnimationDelegate$$ExternalSyntheticLambda2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SearchViewAnimationHelper.ContainedAnimationDelegate.this.m9547xdc9a02e0(valueAnimator);
                }
            });
            return alphaValueAnimator;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$getBackgroundAlphaAnimator$0$com-google-android-material-search-SearchViewAnimationHelper$ContainedAnimationDelegate  reason: not valid java name */
        public /* synthetic */ void m9547xdc9a02e0(ValueAnimator valueAnimator) {
            SearchViewAnimationHelper.this.setBackgroundAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        private Animator getContentAlphaAnimator(boolean z) {
            ValueAnimator alphaValueAnimator = getAlphaValueAnimator(z);
            alphaValueAnimator.setDuration(SearchViewAnimationHelper.this.durationShort2);
            alphaValueAnimator.setStartDelay(z ? SearchViewAnimationHelper.this.durationShort1 : 0L);
            SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
            alphaValueAnimator.setInterpolator(z ? searchViewAnimationHelper.standardAccelerateInterpolator : searchViewAnimationHelper.standardDecelerateInterpolator);
            alphaValueAnimator.addUpdateListener(MultiViewUpdateListener.alphaListener(SearchViewAnimationHelper.this.contentContainer));
            return alphaValueAnimator;
        }

        private Animator getToolbarAlphaAnimator(boolean z) {
            ValueAnimator alphaValueAnimator = getAlphaValueAnimator(z);
            alphaValueAnimator.setDuration(SearchViewAnimationHelper.this.durationShort2);
            SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
            alphaValueAnimator.setInterpolator(z ? searchViewAnimationHelper.standardDecelerateInterpolator : searchViewAnimationHelper.standardAccelerateInterpolator);
            alphaValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.SearchViewAnimationHelper$ContainedAnimationDelegate$$ExternalSyntheticLambda1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SearchViewAnimationHelper.ContainedAnimationDelegate.this.m9549x2edc5246(valueAnimator);
                }
            });
            return alphaValueAnimator;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$getToolbarAlphaAnimator$1$com-google-android-material-search-SearchViewAnimationHelper$ContainedAnimationDelegate  reason: not valid java name */
        public /* synthetic */ void m9549x2edc5246(ValueAnimator valueAnimator) {
            SearchViewAnimationHelper.this.toolbar.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        private ValueAnimator getAlphaValueAnimator(boolean z) {
            float[] fArr = {1.0f, 0.0f};
            if (z) {
                // fill-array-data instruction
                fArr[0] = 0.0f;
                fArr[1] = 1.0f;
                return ValueAnimator.ofFloat(fArr);
            }
            return ValueAnimator.ofFloat(fArr);
        }

        private Animator getDummyTextViewWidthAnimator(boolean z) {
            SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
            TextView textView = z ? searchViewAnimationHelper.searchBar.getTextView() : searchViewAnimationHelper.editText;
            SearchViewAnimationHelper searchViewAnimationHelper2 = SearchViewAnimationHelper.this;
            ValueAnimator ofInt = ValueAnimator.ofInt(textView.getWidth(), (z ? searchViewAnimationHelper2.editText : searchViewAnimationHelper2.searchBar.getTextView()).getWidth());
            ofInt.setDuration(SearchViewAnimationHelper.this.durationShort2);
            SearchViewAnimationHelper searchViewAnimationHelper3 = SearchViewAnimationHelper.this;
            ofInt.setInterpolator(z ? searchViewAnimationHelper3.standardDecelerateInterpolator : searchViewAnimationHelper3.standardAccelerateInterpolator);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.SearchViewAnimationHelper$ContainedAnimationDelegate$$ExternalSyntheticLambda3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SearchViewAnimationHelper.ContainedAnimationDelegate.this.m9548x67b2b750(valueAnimator);
                }
            });
            return ofInt;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$getDummyTextViewWidthAnimator$2$com-google-android-material-search-SearchViewAnimationHelper$ContainedAnimationDelegate  reason: not valid java name */
        public /* synthetic */ void m9548x67b2b750(ValueAnimator valueAnimator) {
            setWidth(SearchViewAnimationHelper.this.dummyTextView, ((Integer) valueAnimator.getAnimatedValue()).intValue());
        }

        private Animator getSearchBarSiblingsTranslationAnimator(boolean z) {
            AnimatorSet animatorSet = new AnimatorSet();
            AppBarLayout appBarLayoutParentIfExists = SearchViewAnimationHelper.this.searchBar.getAppBarLayoutParentIfExists();
            if (SearchViewAnimationHelper.this.searchBar != null && appBarLayoutParentIfExists != null) {
                View startSiblingView = getStartSiblingView(appBarLayoutParentIfExists);
                View endSiblingView = getEndSiblingView(appBarLayoutParentIfExists);
                boolean isLayoutRtl = ViewUtils.isLayoutRtl(SearchViewAnimationHelper.this.searchBar);
                int width = appBarLayoutParentIfExists.getWidth();
                if (startSiblingView != null) {
                    Rect calculateOffsetRectFromBounds = ViewUtils.calculateOffsetRectFromBounds(appBarLayoutParentIfExists, startSiblingView);
                    animatorSet.playTogether(getSiblingTranslationAnimator(startSiblingView, z, isLayoutRtl ? width - calculateOffsetRectFromBounds.left : -calculateOffsetRectFromBounds.right));
                    animatorSet.playTogether(getSiblingAlphaAnimator(startSiblingView, z));
                }
                if (endSiblingView != null) {
                    Rect calculateOffsetRectFromBounds2 = ViewUtils.calculateOffsetRectFromBounds(appBarLayoutParentIfExists, endSiblingView);
                    animatorSet.playTogether(getSiblingTranslationAnimator(endSiblingView, z, isLayoutRtl ? -calculateOffsetRectFromBounds2.right : width - calculateOffsetRectFromBounds2.left));
                    animatorSet.playTogether(getSiblingAlphaAnimator(endSiblingView, z));
                }
                animatorSet.setDuration(SearchViewAnimationHelper.this.durationShort2);
                animatorSet.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
            }
            return animatorSet;
        }

        View getStartSiblingView(AppBarLayout appBarLayout) {
            int startSiblingViewId = SearchViewAnimationHelper.this.searchBar.getStartSiblingViewId();
            if (startSiblingViewId != -1) {
                return appBarLayout.findViewById(startSiblingViewId);
            }
            return getToolbarNavigationIconButton();
        }

        View getEndSiblingView(AppBarLayout appBarLayout) {
            int endSiblingViewId = SearchViewAnimationHelper.this.searchBar.getEndSiblingViewId();
            if (endSiblingViewId != -1) {
                return appBarLayout.findViewById(endSiblingViewId);
            }
            return getToolbarActionMenuView();
        }

        private View getToolbarNavigationIconButton() {
            ViewParent parent = SearchViewAnimationHelper.this.searchBar.getParent();
            if (parent instanceof Toolbar) {
                return ToolbarUtils.getNavigationIconButton((Toolbar) parent);
            }
            return null;
        }

        private View getToolbarActionMenuView() {
            ViewParent parent = SearchViewAnimationHelper.this.searchBar.getParent();
            if (parent instanceof Toolbar) {
                return ToolbarUtils.getActionMenuView((Toolbar) parent);
            }
            return null;
        }

        private Animator getSiblingTranslationAnimator(View view, boolean z, float f) {
            float f2 = z ? 0.0f : f;
            if (!z) {
                f = 0.0f;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f);
            ofFloat.addUpdateListener(MultiViewUpdateListener.translationXListener(view));
            return ofFloat;
        }

        private Animator getSiblingAlphaAnimator(View view, boolean z) {
            ValueAnimator alphaValueAnimator = getAlphaValueAnimator(!z);
            alphaValueAnimator.addUpdateListener(MultiViewUpdateListener.alphaListener(view));
            return alphaValueAnimator;
        }

        private SpringAnimation getToolbarWidthSpringAnimation(final boolean z, final Toolbar toolbar) {
            int width = SearchViewAnimationHelper.this.searchBar.getWidth();
            int toolbarWidth = getToolbarWidth();
            int i = z ? width : toolbarWidth;
            if (z) {
                width = toolbarWidth;
            }
            SpringAnimation springAnimation = getSpringAnimation(toolbar, getWidthViewProperty(), i, width);
            springAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.google.android.material.search.SearchViewAnimationHelper$ContainedAnimationDelegate$$ExternalSyntheticLambda0
                @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f, float f2) {
                    SearchViewAnimationHelper.ContainedAnimationDelegate.this.m9550xf6aa07b8(z, toolbar, dynamicAnimation, z2, f, f2);
                }
            });
            return springAnimation;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$getToolbarWidthSpringAnimation$3$com-google-android-material-search-SearchViewAnimationHelper$ContainedAnimationDelegate  reason: not valid java name */
        public /* synthetic */ void m9550xf6aa07b8(boolean z, Toolbar toolbar, DynamicAnimation dynamicAnimation, boolean z2, float f, float f2) {
            if (z) {
                setWidth(toolbar, -1);
            }
        }

        private SpringAnimation getToolbarWidthSpringAnimation(boolean z) {
            return getToolbarWidthSpringAnimation(z, SearchViewAnimationHelper.this.toolbar);
        }

        private SpringAnimation getDummyToolbarWidthSpringAnimation(boolean z) {
            return getToolbarWidthSpringAnimation(z, SearchViewAnimationHelper.this.dummyToolbar);
        }

        private int getToolbarWidth() {
            int width = SearchViewAnimationHelper.this.toolbarContainer.getWidth();
            int paddingStart = SearchViewAnimationHelper.this.toolbarContainer.getPaddingStart() + SearchViewAnimationHelper.this.toolbarContainer.getPaddingEnd();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) SearchViewAnimationHelper.this.toolbar.getLayoutParams();
            return (width - paddingStart) - (marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd());
        }

        private SpringAnimation getToolbarTranslationXSpringAnimation(boolean z, Toolbar toolbar) {
            int toolbarTranslationX = getToolbarTranslationX(toolbar);
            int i = z ? toolbarTranslationX : 0;
            if (z) {
                toolbarTranslationX = 0;
            }
            return getSpringAnimation(toolbar, SpringAnimation.TRANSLATION_X, i, toolbarTranslationX);
        }

        private SpringAnimation getToolbarTranslationXSpringAnimation(boolean z) {
            return getToolbarTranslationXSpringAnimation(z, SearchViewAnimationHelper.this.toolbar);
        }

        private SpringAnimation getDummyToolbarTranslationXSpringAnimation(boolean z) {
            return getToolbarTranslationXSpringAnimation(z, SearchViewAnimationHelper.this.dummyToolbar);
        }

        private int getToolbarTranslationX(Toolbar toolbar) {
            SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
            int viewLeftFromSearchViewParent = searchViewAnimationHelper.getViewLeftFromSearchViewParent(searchViewAnimationHelper.searchBar);
            int paddingStart = SearchViewAnimationHelper.this.toolbarContainer.getPaddingStart();
            int marginStart = ((ViewGroup.MarginLayoutParams) toolbar.getLayoutParams()).getMarginStart();
            return ViewUtils.isLayoutRtl(SearchViewAnimationHelper.this.searchBar) ? (viewLeftFromSearchViewParent + SearchViewAnimationHelper.this.searchBar.getWidth()) - ((SearchViewAnimationHelper.this.toolbarContainer.getWidth() - paddingStart) - marginStart) : (viewLeftFromSearchViewParent - paddingStart) - marginStart;
        }

        private SpringAnimation getToolbarContainerTranslationYSpringAnimation(boolean z) {
            int toolbarTranslationY = getToolbarTranslationY();
            int i = z ? toolbarTranslationY : 0;
            if (z) {
                toolbarTranslationY = 0;
            }
            return getSpringAnimation(SearchViewAnimationHelper.this.toolbarContainer, SpringAnimation.TRANSLATION_Y, i, toolbarTranslationY);
        }

        private SpringAnimation getEditTextTranslationXSpringAnimation(boolean z) {
            return getTextTranslationXSpringAnimation(z, SearchViewAnimationHelper.this.editText);
        }

        private SpringAnimation getDummyTextTranslationXSpringAnimation(boolean z) {
            return getTextTranslationXSpringAnimation(z, SearchViewAnimationHelper.this.dummyTextView);
        }

        private SpringAnimation getTextTranslationXSpringAnimation(boolean z, View view) {
            TextView placeholderTextView = SearchViewAnimationHelper.this.searchBar.getPlaceholderTextView();
            if (TextUtils.isEmpty(placeholderTextView.getText()) || z) {
                placeholderTextView = SearchViewAnimationHelper.this.searchBar.getTextView();
            }
            float translationXBetweenViews = SearchViewAnimationHelper.this.getTranslationXBetweenViews(placeholderTextView, view) - getToolbarTranslationX(SearchViewAnimationHelper.this.toolbar);
            if (ViewUtils.isLayoutRtl(SearchViewAnimationHelper.this.searchBar)) {
                translationXBetweenViews += placeholderTextView.getWidth() - view.getWidth();
            }
            float f = z ? translationXBetweenViews : 0.0f;
            if (z) {
                translationXBetweenViews = 0.0f;
            }
            return getSpringAnimation(view, SpringAnimation.TRANSLATION_X, f, translationXBetweenViews);
        }

        private int getToolbarTranslationY() {
            SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
            int viewTopFromSearchViewParent = searchViewAnimationHelper.getViewTopFromSearchViewParent(searchViewAnimationHelper.searchBar);
            SearchViewAnimationHelper searchViewAnimationHelper2 = SearchViewAnimationHelper.this;
            return viewTopFromSearchViewParent - searchViewAnimationHelper2.getViewTopFromSearchViewParent(searchViewAnimationHelper2.toolbar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWidth(View view, int i) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = i;
            view.setLayoutParams(layoutParams);
        }

        private FloatPropertyCompat<View> getWidthViewProperty() {
            return new FloatPropertyCompat<View>("width") { // from class: com.google.android.material.search.SearchViewAnimationHelper.ContainedAnimationDelegate.1
                @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
                public float getValue(View view) {
                    return view.getWidth();
                }

                @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
                public void setValue(View view, float f) {
                    ContainedAnimationDelegate.this.setWidth(view, (int) f);
                }
            };
        }

        private SpringAnimation getSpringAnimation(View view, FloatPropertyCompat<View> floatPropertyCompat, float f, float f2) {
            SpringAnimation springAnimation = new SpringAnimation(view, floatPropertyCompat);
            springAnimation.setSpring(MotionUtils.resolveThemeSpringForce(SearchViewAnimationHelper.this.context, R.attr.motionSpringFastSpatial, R.style.Motion_Material3_Spring_Standard_Default_Spatial));
            springAnimation.setStartValue(f);
            springAnimation.getSpring().setFinalPosition(f2);
            return springAnimation;
        }
    }
}
