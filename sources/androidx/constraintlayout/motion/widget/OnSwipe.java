package androidx.constraintlayout.motion.widget;
/* loaded from: classes2.dex */
public class OnSwipe {
    public static final int COMPLETE_MODE_CONTINUOUS_VELOCITY = 0;
    public static final int COMPLETE_MODE_SPRING = 1;
    public static final int DRAG_ANTICLOCKWISE = 7;
    public static final int DRAG_CLOCKWISE = 6;
    public static final int DRAG_DOWN = 1;
    public static final int DRAG_END = 5;
    public static final int DRAG_LEFT = 2;
    public static final int DRAG_RIGHT = 3;
    public static final int DRAG_START = 4;
    public static final int DRAG_UP = 0;
    public static final int FLAG_DISABLE_POST_SCROLL = 1;
    public static final int FLAG_DISABLE_SCROLL = 2;
    public static final int ON_UP_AUTOCOMPLETE = 0;
    public static final int ON_UP_AUTOCOMPLETE_TO_END = 2;
    public static final int ON_UP_AUTOCOMPLETE_TO_START = 1;
    public static final int ON_UP_DECELERATE = 4;
    public static final int ON_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int ON_UP_NEVER_TO_END = 7;
    public static final int ON_UP_NEVER_TO_START = 6;
    public static final int ON_UP_STOP = 3;
    public static final int SIDE_BOTTOM = 3;
    public static final int SIDE_END = 6;
    public static final int SIDE_LEFT = 1;
    public static final int SIDE_MIDDLE = 4;
    public static final int SIDE_RIGHT = 2;
    public static final int SIDE_START = 5;
    public static final int SIDE_TOP = 0;
    public static final int SPRING_BOUNDARY_BOUNCEBOTH = 3;
    public static final int SPRING_BOUNDARY_BOUNCEEND = 2;
    public static final int SPRING_BOUNDARY_BOUNCESTART = 1;
    public static final int SPRING_BOUNDARY_OVERSHOOT = 0;
    private int mDragDirection = 0;
    private int mTouchAnchorSide = 0;
    private int mTouchAnchorId = -1;
    private int mTouchRegionId = -1;
    private int mLimitBoundsTo = -1;
    private int mOnTouchUp = 0;
    private int mRotationCenterId = -1;
    private float mMaxVelocity = 4.0f;
    private float mMaxAcceleration = 1.2f;
    private boolean mMoveWhenScrollAtTop = true;
    private float mDragScale = 1.0f;
    private int mFlags = 0;
    private float mDragThreshold = 10.0f;
    private float mSpringDamping = Float.NaN;
    private float mSpringMass = 1.0f;
    private float mSpringStiffness = Float.NaN;
    private float mSpringStopThreshold = Float.NaN;
    private int mSpringBoundary = 0;
    private int mAutoCompleteMode = 0;

    public OnSwipe setTouchAnchorId(int i) {
        this.mTouchAnchorId = i;
        return this;
    }

    public int getTouchAnchorId() {
        return this.mTouchAnchorId;
    }

    public OnSwipe setTouchAnchorSide(int i) {
        this.mTouchAnchorSide = i;
        return this;
    }

    public int getTouchAnchorSide() {
        return this.mTouchAnchorSide;
    }

    public OnSwipe setDragDirection(int i) {
        this.mDragDirection = i;
        return this;
    }

    public int getDragDirection() {
        return this.mDragDirection;
    }

    public OnSwipe setMaxVelocity(int i) {
        this.mMaxVelocity = i;
        return this;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    public OnSwipe setMaxAcceleration(int i) {
        this.mMaxAcceleration = i;
        return this;
    }

    public float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public OnSwipe setMoveWhenScrollAtTop(boolean z) {
        this.mMoveWhenScrollAtTop = z;
        return this;
    }

    public boolean getMoveWhenScrollAtTop() {
        return this.mMoveWhenScrollAtTop;
    }

    public OnSwipe setDragScale(int i) {
        this.mDragScale = i;
        return this;
    }

    public float getDragScale() {
        return this.mDragScale;
    }

    public OnSwipe setDragThreshold(int i) {
        this.mDragThreshold = i;
        return this;
    }

    public float getDragThreshold() {
        return this.mDragThreshold;
    }

    public OnSwipe setTouchRegionId(int i) {
        this.mTouchRegionId = i;
        return this;
    }

    public int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    public OnSwipe setOnTouchUp(int i) {
        this.mOnTouchUp = i;
        return this;
    }

    public int getOnTouchUp() {
        return this.mOnTouchUp;
    }

    public OnSwipe setNestedScrollFlags(int i) {
        this.mFlags = i;
        return this;
    }

    public int getNestedScrollFlags() {
        return this.mFlags;
    }

    public OnSwipe setLimitBoundsTo(int i) {
        this.mLimitBoundsTo = i;
        return this;
    }

    public int getLimitBoundsTo() {
        return this.mLimitBoundsTo;
    }

    public OnSwipe setRotateCenter(int i) {
        this.mRotationCenterId = i;
        return this;
    }

    public int getRotationCenterId() {
        return this.mRotationCenterId;
    }

    public float getSpringDamping() {
        return this.mSpringDamping;
    }

    public OnSwipe setSpringDamping(float f) {
        this.mSpringDamping = f;
        return this;
    }

    public float getSpringMass() {
        return this.mSpringMass;
    }

    public OnSwipe setSpringMass(float f) {
        this.mSpringMass = f;
        return this;
    }

    public float getSpringStiffness() {
        return this.mSpringStiffness;
    }

    public OnSwipe setSpringStiffness(float f) {
        this.mSpringStiffness = f;
        return this;
    }

    public float getSpringStopThreshold() {
        return this.mSpringStopThreshold;
    }

    public OnSwipe setSpringStopThreshold(float f) {
        this.mSpringStopThreshold = f;
        return this;
    }

    public int getSpringBoundary() {
        return this.mSpringBoundary;
    }

    public OnSwipe setSpringBoundary(int i) {
        this.mSpringBoundary = i;
        return this;
    }

    public int getAutoCompleteMode() {
        return this.mAutoCompleteMode;
    }

    public void setAutoCompleteMode(int i) {
        this.mAutoCompleteMode = i;
    }
}
