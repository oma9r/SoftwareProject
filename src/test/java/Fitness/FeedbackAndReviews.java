package Fitness;

import Fitness.ClientPackage.ProgressTrackingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Random;

import static org.junit.Assert.*;


public class FeedbackAndReviews {
    private ProgressTrackingPage progressTrackingPage;



    public FeedbackAndReviews() {

        progressTrackingPage = new ProgressTrackingPage();
    }




    @When("the user selects a rating between {int} and {int} stars")
    public void the_user_selects_a_rating_between_and_stars(Integer min, Integer max) {
        // Write code to simulate the user selecting a rating
        Random random = new Random();
        int rating = random.nextInt(max - min + 1) + min;

        progressTrackingPage.selectRating(rating);

        System.out.println("User selected a rating of " + rating + " stars.");
    }

    @Then("the system should save the rating for the program")
    public void the_system_should_save_the_rating_for_the_program() {
        // Write code to validate that the rating has been saved
        assertTrue(progressTrackingPage.isRatingSaved());
    }

    @When("the user writes a review in the text box")
    public void the_user_writes_a_review_in_the_text_box() {
        // Write code to simulate the user writing a review
        progressTrackingPage.writeReview("Great program!");

    }

    @Then("the review should be saved")
    public void the_review_should_be_saved() {
        // Write code to validate that the review has been saved
        assertTrue(progressTrackingPage.isReviewSaved());
    }

    @When("the user enters a suggestion for improvement")
    public void the_user_enters_a_suggestion_for_improvement() {
        // Write code to simulate the user entering a suggestion for improvement
        progressTrackingPage.enterSuggestion("More practice sessions.");

    }

    @Then("the suggestion should be sent to the instructor")
    public void the_suggestion_should_be_sent_to_the_instructor() {
        // Write code to validate that the suggestion has been sent to the instructor
        assertTrue(progressTrackingPage.isSuggestionSent());
    }

}
