package Fitness.ClientPackage;

public class ProgressTrackingPage {

    private boolean onProgressTrackingPage;
    private boolean isWeightSaved = false;
    private boolean isBMISaved = false;
    private boolean isAttendanceSaved = false;
    private boolean isBadgeVisible = false;
    private boolean isProgressChartDisplayed = false;
    private ProgressTrackingPage progressTrackingPage;
    private boolean isRatingSaved = false;
    private boolean isReviewSaved = false;
    private boolean isSuggestionSent = false;
    private int selectedRating;

    public ProgressTrackingPage() {
        this.onProgressTrackingPage = false;
    }


    public void navigateToProgressTrackingPage() {

        System.out.println("Navigating to progress tracking page...");
        this.onProgressTrackingPage = true;
    }


    public boolean isOnProgressTrackingPage() {
        return this.onProgressTrackingPage;
    }
    public void enterCurrentWeight(double weight) {

        System.out.println("Entering weight: " + weight);
        this.isWeightSaved = true;
    }
    public boolean isWeightSaved() {
        return isWeightSaved;
    }

    public boolean isWeightDisplayed() {

        return isWeightSaved;
    }

    public void enterCurrentBMI(double bmi) {

        System.out.println("Entering BMI: " + bmi);
        this.isBMISaved = true;
    }

    public boolean isBMISaved() {
        return isBMISaved;
    }

    public boolean isBMIDisplayed() {

        return isBMISaved;
    }

    public void logAttendance() {

        System.out.println("Logging attendance...");
        this.isAttendanceSaved = true;
    }

    public boolean isAttendanceSaved() {
        return isAttendanceSaved;
    }

    public boolean isAttendanceHistoryDisplayed() {

        return isAttendanceSaved;
    }

    public void completeProgram() {

        System.out.println("User has completed the program.");
    }

    public void viewAchievementsPage() {

        System.out.println("Viewing achievements page...");
        this.isBadgeVisible = true;
    }

    public boolean isBadgeVisible() {
        return isBadgeVisible;
    }

    public void trackMilestones() {

        System.out.println("Tracking milestones...");
    }

    public void viewProgressChart() {

        System.out.println("Viewing progress chart...");
        this.isProgressChartDisplayed = true;
    }

    public boolean isProgressChartDisplayed() {
        return isProgressChartDisplayed;
    }
    public void selectRating(int rating) {
        this.selectedRating = rating;
        this.isRatingSaved = true;
        System.out.println("User selected a rating of " + rating + " stars.");
    }

    public boolean isRatingSaved() {
        return isRatingSaved;
    }
    public void writeReview(String review) {
        System.out.println("User wrote a review: " + review);
        this.isReviewSaved = true;
    }


    public boolean isReviewSaved() {
        return isReviewSaved;
    }
    public void enterSuggestion(String suggestion) {
        System.out.println("User entered a suggestion: " + suggestion);
        this.isSuggestionSent = true;
    }


    public boolean isSuggestionSent() {
        return isSuggestionSent;
    }
}
