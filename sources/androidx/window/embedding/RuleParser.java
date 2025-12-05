package androidx.window.embedding;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import androidx.window.R;
import androidx.window.embedding.ActivityRule;
import androidx.window.embedding.EmbeddingAnimationParams;
import androidx.window.embedding.SplitAttributes;
import androidx.window.embedding.SplitPairRule;
import androidx.window.embedding.SplitPlaceholderRule;
import androidx.window.embedding.SplitRule;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: RuleParser.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ$\u0010\f\u001a\u00020\r*\u0012\u0012\u0004\u0012\u00020\u00060\u000ej\b\u0012\u0004\u0012\u00020\u0006`\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002¨\u0006%"}, d2 = {"Landroidx/window/embedding/RuleParser;", "", "<init>", "()V", "parseRules", "", "Landroidx/window/embedding/EmbeddingRule;", "context", "Landroid/content/Context;", "staticRuleResourceId", "", "parseRules$window_release", "addRuleWithDuplicatedTagCheck", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "rule", "parseSplitPairRule", "Landroidx/window/embedding/SplitPairRule;", "parser", "Landroid/content/res/XmlResourceParser;", "parseSplitPlaceholderRule", "Landroidx/window/embedding/SplitPlaceholderRule;", "parseSplitPairFilter", "Landroidx/window/embedding/SplitPairFilter;", "parseActivityRule", "Landroidx/window/embedding/ActivityRule;", "parseActivityFilter", "Landroidx/window/embedding/ActivityFilter;", "parseDividerAttributes", "Landroidx/window/embedding/DividerAttributes;", "buildClassName", "Landroid/content/ComponentName;", "pkg", "", "clsSeq", "", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RuleParser {
    public static final RuleParser INSTANCE = new RuleParser();

    private RuleParser() {
    }

    public final Set<EmbeddingRule> parseRules$window_release(Context context, int i) {
        SplitPlaceholderRule build;
        SplitPairRule build2;
        ActivityRule plus$window_release;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            XmlResourceParser xml = context.getResources().getXml(i);
            Intrinsics.checkNotNullExpressionValue(xml, "getXml(...)");
            HashSet<EmbeddingRule> hashSet = new HashSet<>();
            int depth = xml.getDepth();
            int next = xml.next();
            SplitPairRule splitPairRule = null;
            ActivityRule activityRule = null;
            SplitPlaceholderRule splitPlaceholderRule = null;
            while (next != 1 && (next != 3 || xml.getDepth() > depth)) {
                if (xml.getEventType() != 2 || Intrinsics.areEqual("split-config", xml.getName())) {
                    next = xml.next();
                } else {
                    String name = xml.getName();
                    if (name != null) {
                        switch (name.hashCode()) {
                            case 304713008:
                                if (name.equals("DividerAttributes")) {
                                    if (splitPairRule != null || splitPlaceholderRule != null) {
                                        DividerAttributes parseDividerAttributes = parseDividerAttributes(context, xml);
                                        if (splitPairRule == null) {
                                            if (splitPlaceholderRule != null) {
                                                hashSet.remove(splitPlaceholderRule);
                                                build = new SplitPlaceholderRule.Builder(splitPlaceholderRule).setDefaultSplitAttributes(new SplitAttributes.Builder(splitPlaceholderRule.getDefaultSplitAttributes()).setDividerAttributes(parseDividerAttributes).build()).build();
                                                addRuleWithDuplicatedTagCheck(hashSet, build);
                                                splitPlaceholderRule = build;
                                                break;
                                            }
                                        } else {
                                            hashSet.remove(splitPairRule);
                                            build2 = new SplitPairRule.Builder(splitPairRule).setDefaultSplitAttributes(new SplitAttributes.Builder(splitPairRule.getDefaultSplitAttributes()).setDividerAttributes(parseDividerAttributes).build()).build();
                                            addRuleWithDuplicatedTagCheck(hashSet, build2);
                                            splitPairRule = build2;
                                            break;
                                        }
                                    } else {
                                        throw new IllegalArgumentException("Found orphaned DividerAttributes");
                                    }
                                }
                                break;
                            case 511422343:
                                if (name.equals("ActivityFilter")) {
                                    if (activityRule != null || splitPlaceholderRule != null) {
                                        ActivityFilter parseActivityFilter = parseActivityFilter(context, xml);
                                        if (activityRule == null) {
                                            if (splitPlaceholderRule != null) {
                                                hashSet.remove(splitPlaceholderRule);
                                                build = splitPlaceholderRule.plus$window_release(parseActivityFilter);
                                                addRuleWithDuplicatedTagCheck(hashSet, build);
                                                splitPlaceholderRule = build;
                                                break;
                                            }
                                        } else {
                                            hashSet.remove(activityRule);
                                            plus$window_release = activityRule.plus$window_release(parseActivityFilter);
                                            addRuleWithDuplicatedTagCheck(hashSet, plus$window_release);
                                            activityRule = plus$window_release;
                                            break;
                                        }
                                    } else {
                                        throw new IllegalArgumentException("Found orphaned ActivityFilter");
                                    }
                                }
                                break;
                            case 520447504:
                                if (name.equals("SplitPairRule")) {
                                    build2 = parseSplitPairRule(context, xml);
                                    addRuleWithDuplicatedTagCheck(hashSet, build2);
                                    activityRule = null;
                                    splitPlaceholderRule = null;
                                    splitPairRule = build2;
                                    break;
                                }
                                break;
                            case 1579230604:
                                if (name.equals("SplitPairFilter")) {
                                    if (splitPairRule != null) {
                                        SplitPairFilter parseSplitPairFilter = parseSplitPairFilter(context, xml);
                                        hashSet.remove(splitPairRule);
                                        build2 = splitPairRule.plus$window_release(parseSplitPairFilter);
                                        addRuleWithDuplicatedTagCheck(hashSet, build2);
                                        splitPairRule = build2;
                                        break;
                                    } else {
                                        throw new IllegalArgumentException("Found orphaned SplitPairFilter outside of SplitPairRule");
                                    }
                                }
                                break;
                            case 1793077963:
                                if (name.equals("ActivityRule")) {
                                    plus$window_release = parseActivityRule(context, xml);
                                    addRuleWithDuplicatedTagCheck(hashSet, plus$window_release);
                                    splitPairRule = null;
                                    splitPlaceholderRule = null;
                                    activityRule = plus$window_release;
                                    break;
                                }
                                break;
                            case 2050988213:
                                if (name.equals("SplitPlaceholderRule")) {
                                    build = parseSplitPlaceholderRule(context, xml);
                                    addRuleWithDuplicatedTagCheck(hashSet, build);
                                    splitPairRule = null;
                                    activityRule = null;
                                    splitPlaceholderRule = build;
                                    break;
                                }
                                break;
                        }
                    }
                    next = xml.next();
                }
            }
            return hashSet;
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    private final void addRuleWithDuplicatedTagCheck(HashSet<EmbeddingRule> hashSet, EmbeddingRule embeddingRule) {
        String tag = embeddingRule.getTag();
        for (EmbeddingRule embeddingRule2 : hashSet) {
            if (tag != null && Intrinsics.areEqual(tag, embeddingRule2.getTag())) {
                throw new IllegalArgumentException("Duplicated tag: " + tag + " for " + embeddingRule + ". The tag must be unique in XML rule definition.");
            }
        }
        hashSet.add(embeddingRule);
    }

    private final SplitPairRule parseSplitPairRule(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(xmlResourceParser, R.styleable.SplitPairRule, 0, 0);
        String string = obtainStyledAttributes.getString(R.styleable.SplitPairRule_tag);
        float f = obtainStyledAttributes.getFloat(R.styleable.SplitPairRule_splitRatio, 0.5f);
        int integer = obtainStyledAttributes.getInteger(R.styleable.SplitPairRule_splitMinWidthDp, 600);
        int integer2 = obtainStyledAttributes.getInteger(R.styleable.SplitPairRule_splitMinHeightDp, 600);
        int integer3 = obtainStyledAttributes.getInteger(R.styleable.SplitPairRule_splitMinSmallestWidthDp, 600);
        float f2 = obtainStyledAttributes.getFloat(R.styleable.SplitPairRule_splitMaxAspectRatioInPortrait, SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT.getValue$window_release());
        float f3 = obtainStyledAttributes.getFloat(R.styleable.SplitPairRule_splitMaxAspectRatioInLandscape, SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT.getValue$window_release());
        int i = obtainStyledAttributes.getInt(R.styleable.SplitPairRule_splitLayoutDirection, SplitAttributes.LayoutDirection.LOCALE.getValue$window_release());
        int i2 = obtainStyledAttributes.getInt(R.styleable.SplitPairRule_finishPrimaryWithSecondary, SplitRule.FinishBehavior.NEVER.getValue$window_release());
        int i3 = obtainStyledAttributes.getInt(R.styleable.SplitPairRule_finishSecondaryWithPrimary, SplitRule.FinishBehavior.ALWAYS.getValue$window_release());
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SplitPairRule_clearTop, false);
        int color = obtainStyledAttributes.getColor(R.styleable.SplitPairRule_animationBackgroundColor, 0);
        int i4 = obtainStyledAttributes.getInt(R.styleable.SplitPairRule_splitOpenAnimation, EmbeddingAnimationParams.AnimationSpec.DEFAULT.getValue$window_release());
        int i5 = obtainStyledAttributes.getInt(R.styleable.SplitPairRule_splitCloseAnimation, EmbeddingAnimationParams.AnimationSpec.DEFAULT.getValue$window_release());
        int i6 = obtainStyledAttributes.getInt(R.styleable.SplitPairRule_splitChangeAnimation, EmbeddingAnimationParams.AnimationSpec.DEFAULT.getValue$window_release());
        obtainStyledAttributes.recycle();
        return new SplitPairRule.Builder(SetsKt.emptySet()).setTag(string).setMinWidthDp(integer).setMinHeightDp(integer2).setMinSmallestWidthDp(integer3).setMaxAspectRatioInPortrait(EmbeddingAspectRatio.Companion.buildAspectRatioFromValue$window_release(f2)).setMaxAspectRatioInLandscape(EmbeddingAspectRatio.Companion.buildAspectRatioFromValue$window_release(f3)).setFinishPrimaryWithSecondary(SplitRule.FinishBehavior.Companion.getFinishBehaviorFromValue$window_release(i2)).setFinishSecondaryWithPrimary(SplitRule.FinishBehavior.Companion.getFinishBehaviorFromValue$window_release(i3)).setClearTop(z).setDefaultSplitAttributes(new SplitAttributes.Builder().setSplitType(SplitAttributes.SplitType.Companion.buildSplitTypeFromValue$window_release(f)).setLayoutDirection(SplitAttributes.LayoutDirection.Companion.getLayoutDirectionFromValue$window_release(i)).setAnimationParams(new EmbeddingAnimationParams.Builder().setAnimationBackground(EmbeddingAnimationBackground.Companion.buildFromValue$window_release(color)).setOpenAnimation(EmbeddingAnimationParams.AnimationSpec.Companion.getAnimationSpecFromValue$window_release(i4)).setCloseAnimation(EmbeddingAnimationParams.AnimationSpec.Companion.getAnimationSpecFromValue$window_release(i5)).setChangeAnimation(EmbeddingAnimationParams.AnimationSpec.Companion.getAnimationSpecFromValue$window_release(i6)).build()).build()).build();
    }

    private final SplitPlaceholderRule parseSplitPlaceholderRule(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(xmlResourceParser, R.styleable.SplitPlaceholderRule, 0, 0);
        String string = obtainStyledAttributes.getString(R.styleable.SplitPlaceholderRule_tag);
        String string2 = obtainStyledAttributes.getString(R.styleable.SplitPlaceholderRule_placeholderActivityName);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SplitPlaceholderRule_stickyPlaceholder, false);
        int i = obtainStyledAttributes.getInt(R.styleable.SplitPlaceholderRule_finishPrimaryWithPlaceholder, SplitRule.FinishBehavior.ALWAYS.getValue$window_release());
        if (i == SplitRule.FinishBehavior.NEVER.getValue$window_release()) {
            throw new IllegalArgumentException("Never is not a valid configuration for Placeholder activities. Please use FINISH_ALWAYS or FINISH_ADJACENT instead or refer to the current API");
        }
        float f = obtainStyledAttributes.getFloat(R.styleable.SplitPlaceholderRule_splitRatio, 0.5f);
        int integer = obtainStyledAttributes.getInteger(R.styleable.SplitPlaceholderRule_splitMinWidthDp, 600);
        int integer2 = obtainStyledAttributes.getInteger(R.styleable.SplitPlaceholderRule_splitMinHeightDp, 600);
        int integer3 = obtainStyledAttributes.getInteger(R.styleable.SplitPlaceholderRule_splitMinSmallestWidthDp, 600);
        float f2 = obtainStyledAttributes.getFloat(R.styleable.SplitPlaceholderRule_splitMaxAspectRatioInPortrait, SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT.getValue$window_release());
        float f3 = obtainStyledAttributes.getFloat(R.styleable.SplitPlaceholderRule_splitMaxAspectRatioInLandscape, SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT.getValue$window_release());
        int i2 = obtainStyledAttributes.getInt(R.styleable.SplitPlaceholderRule_splitLayoutDirection, SplitAttributes.LayoutDirection.LOCALE.getValue$window_release());
        int color = obtainStyledAttributes.getColor(R.styleable.SplitPlaceholderRule_animationBackgroundColor, 0);
        int i3 = obtainStyledAttributes.getInt(R.styleable.SplitPlaceholderRule_splitOpenAnimation, EmbeddingAnimationParams.AnimationSpec.DEFAULT.getValue$window_release());
        int i4 = obtainStyledAttributes.getInt(R.styleable.SplitPlaceholderRule_splitCloseAnimation, EmbeddingAnimationParams.AnimationSpec.DEFAULT.getValue$window_release());
        int i5 = obtainStyledAttributes.getInt(R.styleable.SplitPlaceholderRule_splitChangeAnimation, EmbeddingAnimationParams.AnimationSpec.DEFAULT.getValue$window_release());
        obtainStyledAttributes.recycle();
        SplitAttributes build = new SplitAttributes.Builder().setSplitType(SplitAttributes.SplitType.Companion.buildSplitTypeFromValue$window_release(f)).setLayoutDirection(SplitAttributes.LayoutDirection.Companion.getLayoutDirectionFromValue$window_release(i2)).setAnimationParams(new EmbeddingAnimationParams.Builder().setAnimationBackground(EmbeddingAnimationBackground.Companion.buildFromValue$window_release(color)).setOpenAnimation(EmbeddingAnimationParams.AnimationSpec.Companion.getAnimationSpecFromValue$window_release(i3)).setCloseAnimation(EmbeddingAnimationParams.AnimationSpec.Companion.getAnimationSpecFromValue$window_release(i4)).setChangeAnimation(EmbeddingAnimationParams.AnimationSpec.Companion.getAnimationSpecFromValue$window_release(i5)).build()).build();
        String packageName = context.getApplicationContext().getPackageName();
        RuleParser ruleParser = INSTANCE;
        Intrinsics.checkNotNull(packageName);
        ComponentName buildClassName = ruleParser.buildClassName(packageName, string2);
        Set emptySet = SetsKt.emptySet();
        Intent component = new Intent().setComponent(buildClassName);
        Intrinsics.checkNotNullExpressionValue(component, "setComponent(...)");
        return new SplitPlaceholderRule.Builder(emptySet, component).setTag(string).setMinWidthDp(integer).setMinHeightDp(integer2).setMinSmallestWidthDp(integer3).setMaxAspectRatioInPortrait(EmbeddingAspectRatio.Companion.buildAspectRatioFromValue$window_release(f2)).setMaxAspectRatioInLandscape(EmbeddingAspectRatio.Companion.buildAspectRatioFromValue$window_release(f3)).setSticky(z).setFinishPrimaryWithPlaceholder(SplitRule.FinishBehavior.Companion.getFinishBehaviorFromValue$window_release(i)).setDefaultSplitAttributes(build).build();
    }

    private final SplitPairFilter parseSplitPairFilter(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(xmlResourceParser, R.styleable.SplitPairFilter, 0, 0);
        String string = obtainStyledAttributes.getString(R.styleable.SplitPairFilter_primaryActivityName);
        String string2 = obtainStyledAttributes.getString(R.styleable.SplitPairFilter_secondaryActivityName);
        String string3 = obtainStyledAttributes.getString(R.styleable.SplitPairFilter_secondaryActivityAction);
        String packageName = context.getApplicationContext().getPackageName();
        Intrinsics.checkNotNull(packageName);
        return new SplitPairFilter(buildClassName(packageName, string), buildClassName(packageName, string2), string3);
    }

    private final ActivityRule parseActivityRule(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(xmlResourceParser, R.styleable.ActivityRule, 0, 0);
        String string = obtainStyledAttributes.getString(R.styleable.ActivityRule_tag);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.ActivityRule_alwaysExpand, false);
        obtainStyledAttributes.recycle();
        ActivityRule.Builder alwaysExpand = new ActivityRule.Builder(SetsKt.emptySet()).setAlwaysExpand(z);
        if (string != null) {
            alwaysExpand.setTag(string);
        }
        return alwaysExpand.build();
    }

    private final ActivityFilter parseActivityFilter(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(xmlResourceParser, R.styleable.ActivityFilter, 0, 0);
        String string = obtainStyledAttributes.getString(R.styleable.ActivityFilter_activityName);
        String string2 = obtainStyledAttributes.getString(R.styleable.ActivityFilter_activityAction);
        String packageName = context.getApplicationContext().getPackageName();
        Intrinsics.checkNotNull(packageName);
        return new ActivityFilter(buildClassName(packageName, string), string2);
    }

    private final DividerAttributes parseDividerAttributes(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(xmlResourceParser, R.styleable.DividerAttributes, 0, 0);
        int i = obtainStyledAttributes.getInt(R.styleable.DividerAttributes_embeddingDividerType, 0);
        DividerAttributes.Companion.validateXmlDividerAttributes$window_release(i, obtainStyledAttributes.hasValue(R.styleable.DividerAttributes_dragRangeMinRatio), obtainStyledAttributes.hasValue(R.styleable.DividerAttributes_dragRangeMaxRatio), obtainStyledAttributes.hasValue(R.styleable.DividerAttributes_isDraggingToFullscreenAllowed));
        return DividerAttributes.Companion.createDividerAttributes$window_release(i, obtainStyledAttributes.getInt(R.styleable.DividerAttributes_embeddingDividerWidthDp, -1), obtainStyledAttributes.getColor(R.styleable.DividerAttributes_embeddingDividerColor, -16777216), obtainStyledAttributes.getFloat(R.styleable.DividerAttributes_dragRangeMinRatio, -1.0f), obtainStyledAttributes.getFloat(R.styleable.DividerAttributes_dragRangeMaxRatio, -1.0f), obtainStyledAttributes.getBoolean(R.styleable.DividerAttributes_isDraggingToFullscreenAllowed, false));
    }

    private final ComponentName buildClassName(String str, CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            throw new IllegalArgumentException("Activity name must not be null");
        }
        String obj = charSequence.toString();
        if (obj.charAt(0) == '.') {
            return new ComponentName(str, str + obj);
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) obj, '/', 0, false, 6, (Object) null);
        if (indexOf$default > 0) {
            str = obj.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
            obj = obj.substring(indexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(obj, "substring(...)");
        }
        if (!Intrinsics.areEqual(obj, "*") && StringsKt.indexOf$default((CharSequence) obj, '.', 0, false, 6, (Object) null) < 0) {
            return new ComponentName(str, str + '.' + obj);
        }
        return new ComponentName(str, obj);
    }
}
