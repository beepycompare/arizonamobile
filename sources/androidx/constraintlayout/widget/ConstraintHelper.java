package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class ConstraintHelper extends View {
    protected static final String CHILD_TAG = "CONSTRAINT_LAYOUT_HELPER_CHILD";
    protected int mCount;
    protected Helper mHelperWidget;
    protected int[] mIds;
    protected HashMap<Integer, String> mMap;
    protected String mReferenceIds;
    protected String mReferenceTags;
    protected boolean mUseViewMeasure;
    private View[] mViews;
    protected Context myContext;

    public void applyHelperParams() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyLayoutFeaturesInConstraintSet(ConstraintLayout constraintLayout) {
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    public void resolveRtl(ConstraintWidget constraintWidget, boolean z) {
    }

    public void updatePostConstraints(ConstraintLayout constraintLayout) {
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
    }

    public ConstraintHelper(Context context) {
        super(context);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(null);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.mReferenceIds = string;
                    setIds(string);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.mReferenceTags = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.mReferenceIds;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.mReferenceTags;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    public void addView(View view) {
        if (view == this) {
            return;
        }
        if (view.getId() == -1) {
            Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
        } else if (view.getParent() == null) {
            Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
        } else {
            this.mReferenceIds = null;
            addRscID(view.getId());
            requestLayout();
        }
    }

    public int removeView(View view) {
        int i;
        int id = view.getId();
        int i2 = -1;
        if (id == -1) {
            return -1;
        }
        this.mReferenceIds = null;
        int i3 = 0;
        while (true) {
            if (i3 >= this.mCount) {
                break;
            } else if (this.mIds[i3] == id) {
                int i4 = i3;
                while (true) {
                    i = this.mCount;
                    if (i4 >= i - 1) {
                        break;
                    }
                    int[] iArr = this.mIds;
                    int i5 = i4 + 1;
                    iArr[i4] = iArr[i5];
                    i4 = i5;
                }
                this.mIds[i - 1] = 0;
                this.mCount = i - 1;
                i2 = i3;
            } else {
                i3++;
            }
        }
        requestLayout();
        return i2;
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.mIds, this.mCount);
    }

    public void setReferencedIds(int[] iArr) {
        this.mReferenceIds = null;
        this.mCount = 0;
        for (int i : iArr) {
            addRscID(i);
        }
    }

    private void addRscID(int i) {
        if (i == getId()) {
            return;
        }
        int i2 = this.mCount + 1;
        int[] iArr = this.mIds;
        if (i2 > iArr.length) {
            this.mIds = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.mIds;
        int i3 = this.mCount;
        iArr2[i3] = i;
        this.mCount = i3 + 1;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mUseViewMeasure) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void validateParams() {
        if (this.mHelperWidget == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).mWidget = (ConstraintWidget) this.mHelperWidget;
        }
    }

    private void addID(String str) {
        if (str == null || str.length() == 0 || this.myContext == null) {
            return;
        }
        String trim = str.trim();
        int findId = findId(trim);
        if (findId != 0) {
            this.mMap.put(Integer.valueOf(findId), trim);
            addRscID(findId);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    private void addTag(String str) {
        if (str == null || str.length() == 0 || this.myContext == null) {
            return;
        }
        String trim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.LayoutParams) && trim.equals(((ConstraintLayout.LayoutParams) layoutParams).constraintTag)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    addRscID(childAt.getId());
                }
            }
        }
    }

    private int findId(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                i = ((Integer) designInformation).intValue();
            }
        }
        if (i == 0 && constraintLayout != null) {
            i = findId(constraintLayout, str);
        }
        if (i == 0) {
            try {
                i = R.id.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return i == 0 ? this.myContext.getResources().getIdentifier(str, "id", this.myContext.getPackageName()) : i;
    }

    private int findId(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str == null || constraintLayout == null || (resources = this.myContext.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            if (childAt.getId() != -1) {
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    str2 = null;
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    protected void setIds(String str) {
        this.mReferenceIds = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.mCount = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                addID(str.substring(i));
                return;
            } else {
                addID(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    protected void setReferenceTags(String str) {
        this.mReferenceTags = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.mCount = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                addTag(str.substring(i));
                return;
            } else {
                addTag(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyLayoutFeatures(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i = 0; i < this.mCount; i++) {
            View viewById = constraintLayout.getViewById(this.mIds[i]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyLayoutFeatures() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        applyLayoutFeatures((ConstraintLayout) parent);
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        String str;
        int findId;
        if (isInEditMode()) {
            setIds(this.mReferenceIds);
        }
        Helper helper = this.mHelperWidget;
        if (helper == null) {
            return;
        }
        helper.removeAllIds();
        for (int i = 0; i < this.mCount; i++) {
            int i2 = this.mIds[i];
            View viewById = constraintLayout.getViewById(i2);
            if (viewById == null && (findId = findId(constraintLayout, (str = this.mMap.get(Integer.valueOf(i2))))) != 0) {
                this.mIds[i] = findId;
                this.mMap.put(Integer.valueOf(findId), str);
                viewById = constraintLayout.getViewById(findId);
            }
            if (viewById != null) {
                this.mHelperWidget.add(constraintLayout.getViewWidget(viewById));
            }
        }
        this.mHelperWidget.updateConstraints(constraintLayout.mLayoutWidget);
    }

    public void updatePreLayout(ConstraintWidgetContainer constraintWidgetContainer, Helper helper, SparseArray<ConstraintWidget> sparseArray) {
        helper.removeAllIds();
        for (int i = 0; i < this.mCount; i++) {
            helper.add(sparseArray.get(this.mIds[i]));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View[] getViews(ConstraintLayout constraintLayout) {
        View[] viewArr = this.mViews;
        if (viewArr == null || viewArr.length != this.mCount) {
            this.mViews = new View[this.mCount];
        }
        for (int i = 0; i < this.mCount; i++) {
            this.mViews[i] = constraintLayout.getViewById(this.mIds[i]);
        }
        return this.mViews;
    }

    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        if (constraint.layout.mReferenceIds != null) {
            setReferencedIds(constraint.layout.mReferenceIds);
        } else if (constraint.layout.mReferenceIdString != null) {
            if (constraint.layout.mReferenceIdString.length() > 0) {
                constraint.layout.mReferenceIds = convertReferenceString(constraint.layout.mReferenceIdString);
            } else {
                constraint.layout.mReferenceIds = null;
            }
        }
        if (helperWidget != null) {
            helperWidget.removeAllIds();
            if (constraint.layout.mReferenceIds != null) {
                for (int i = 0; i < constraint.layout.mReferenceIds.length; i++) {
                    ConstraintWidget constraintWidget = sparseArray.get(constraint.layout.mReferenceIds[i]);
                    if (constraintWidget != null) {
                        helperWidget.add(constraintWidget);
                    }
                }
            }
        }
    }

    private int[] convertReferenceString(String str) {
        String[] split = str.split(StringUtils.COMMA);
        int[] iArr = new int[split.length];
        int i = 0;
        for (String str2 : split) {
            int findId = findId(str2.trim());
            if (findId != 0) {
                iArr[i] = findId;
                i++;
            }
        }
        return i != split.length ? Arrays.copyOf(iArr, i) : iArr;
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        super.setTag(i, obj);
        if (obj == null && this.mReferenceIds == null) {
            addRscID(i);
        }
    }

    public boolean containsId(int i) {
        for (int i2 : this.mIds) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public int indexFromId(int i) {
        int i2 = -1;
        for (int i3 : this.mIds) {
            i2++;
            if (i3 == i) {
                return i2;
            }
        }
        return i2;
    }

    public static boolean isChildOfHelper(View view) {
        return CHILD_TAG == view.getTag();
    }
}
