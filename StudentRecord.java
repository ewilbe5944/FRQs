 


/**
 * Calculate a student's grade average except if the grades all improved.
 * If all grades are better than or the same as the one before it, only average 
 * the scores starting at the number of scores /2. Else, its a normal average.
 *
 * @author Emily Wilber
 * @version November 13, 2018
 */
public class StudentRecord
{
    
    private int[] scores;
    
    /**
     * Makes array scores accessable
     * @param scores   the list of grades to be averaged
     */
    public StudentRecord(int[] scores) {
        this.scores = scores;
    }
    
    /**
     * Returns the average of the values in scores
     * @param first  the starting point of the values to be averaged
     * @param last   the ending point (included) of the values to be averaged
     * @return       the average of all the scores between first and last inclusive  
     */
    private double average(int first, int last)
    {
        double sum = 0.0;
        for (int i = first; i <= last; i++) {
            sum += scores[i];
        }
        return sum/ (last - first + 1);
    }

    /**
     * Returns true if each successive value in scores is greater than or 
     * equal to the previous value or false if not
     *
     * @return  True if scores all improve or false if they dont
     */
    private boolean hasImproved()
    {
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < scores[i-1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * If all scores have improved, return average of the second half
     * If all scores have not improved, return average of all values
     *
     * @return  The correct average depending on whether or not all values
     *          are increasing
     */
    public double finalAverage()
    {
        if (hasImproved()) {
            return average(scores.length/2, scores.length - 1);
        }
        else {
            return average(0, scores.length-1);
        }
    }
}
