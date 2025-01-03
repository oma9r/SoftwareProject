package Fitness.ClientPackage;

/**
 * This class represents the progress tracking page, where the user can track their weight, BMI, attendance,
 * achievements, milestones, and progress chart. The user can also provide ratings, reviews, and suggestions
 * for the program.
 *
 * @author Abdulrhman M Sawalmeh
 */
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

    /**
     * Constructor to initialize the ProgressTrackingPage with the user not being on the page initially.
     */
    public ProgressTrackingPage() {
        this.onProgressTrackingPage = false;
    }

    /**
     * Navigates to the progress tracking page.
     */
    public void navigateToProgressTrackingPage() {
        System.out.println("Navigating to progress tracking page...");
        this.onProgressTrackingPage = true;
    }

    /**
     * Checks if the user is on the progress tracking page.
     *
     * @return true if the user is on the progress tracking page, false otherwise.
     */
    public boolean isOnProgressTrackingPage() {
        return this.onProgressTrackingPage;
    }

    /**
     * Enters the current weight of the user.
     *
     * @param weight the current weight of the user.
     */
    public void enterCurrentWeight(double weight) {
        System.out.println("Entering weight: " + weight);
        this.isWeightSaved = true;
    }

    /**
     * Checks if the weight has been saved.
     *
     * @return true if the weight has been saved, false otherwise.
     */
    public boolean isWeightSaved() {
        return isWeightSaved;
    }

    /**
     * Checks if the weight is displayed.
     *
     * @return true if the weight is displayed, false otherwise.
     */
    public boolean isWeightDisplayed() {
        return isWeightSaved;
    }

    /**
     * Enters the current BMI of the user.
     *
     * @param bmi the current BMI of the user.
     */
    public void enterCurrentBMI(double bmi) {
        System.out.println("Entering BMI: " + bmi);
        this.isBMISaved = true;
    }

    /**
     * Checks if the BMI has been saved.
     *
     * @return true if the BMI has been saved, false otherwise.
     */
    public boolean isBMISaved() {
        return isBMISaved;
    }

    /**
     * Checks if the BMI is displayed.
     *
     * @return true if the BMI is displayed, false otherwise.
     */
    public boolean isBMIDisplayed() {
        return isBMISaved;
    }

    /**
     * Logs the attendance of the user.
     */
    public void logAttendance() {
        System.out.println("Logging attendance...");
        this.isAttendanceSaved = true;
    }

    /**
     * Checks if the attendance has been saved.
     *
     * @return true if the attendance has been saved, false otherwise.
     */
    public boolean isAttendanceSaved() {
        return isAttendanceSaved;
    }

    /**
     * Checks if the attendance history is displayed.
     *
     * @return true if the attendance history is displayed, false otherwise.
     */
    public boolean isAttendanceHistoryDisplayed() {
        return isAttendanceSaved;
    }

    /**
     * Completes the program and logs the completion.
     */
    public void completeProgram() {
        System.out.println("User has completed the program.");
    }

    /**
     * Views the achievements page and sets the badge as visible.
     */
    public void viewAchievementsPage() {
        System.out.println("Viewing achievements page...");
        this.isBadgeVisible = true;
    }

    /**
     * Checks if the badge is visible.
     *
     * @return true if the badge is visible, false otherwise.
     */
    public boolean isBadgeVisible() {
        return isBadgeVisible;
    }

    /**
     * Tracks the milestones of the user.
     */
    public void trackMilestones() {
        System.out.println("Tracking milestones...");
    }

    /**
     * Views the progress chart and sets it as displayed.
     */
    public void viewProgressChart() {
        System.out.println("Viewing progress chart...");
        this.isProgressChartDisplayed = true;
    }

    /**
     * Checks if the progress chart is displayed.
     *
     * @return true if the progress chart is displayed, false otherwise.
     */
    public boolean isProgressChartDisplayed() {
        return isProgressChartDisplayed;
    }

    /**
     * Selects a rating for the program.
     *
     * @param rating the rating selected by the user (e.g., 1 to 5 stars).
     */
    public void selectRating(int rating) {
        this.selectedRating = rating;
        this.isRatingSaved = true;
        System.out.println("User selected a rating of " + rating + " stars.");
    }

    /**
     * Checks if the rating has been saved.
     *
     * @return true if the rating has been saved, false otherwise.
     */
    public boolean isRatingSaved() {
        return isRatingSaved;
    }

    /**
     * Writes a review for the program.
     *
     * @param review the review written by the user.
     */
    public void writeReview(String review) {
        System.out.println("User wrote a review: " + review);
        this.isReviewSaved = true;
    }

    /**
     * Checks if the review has been saved.
     *
     * @return true if the review has been saved, false otherwise.
     */
    public boolean isReviewSaved() {
        return isReviewSaved;
    }

    /**
     * Enters a suggestion for the program.
     *
     * @param suggestion the suggestion provided by the user.
     */
    public void enterSuggestion(String suggestion) {
        System.out.println("User entered a suggestion: " + suggestion);
        this.isSuggestionSent = true;
    }

    /**
     * Checks if the suggestion has been sent.
     *
     * @return true if the suggestion has been sent, false otherwise.
     */
    public boolean isSuggestionSent() {
        return isSuggestionSent;
    }
}
