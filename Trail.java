
/**
 * Information about a hiking trail is kept in a array. Each index in the array holds the elevation 
 * at a point. 
 *
 * @author Emily Wilber
 * @version November 16, 2018
 */
public class Trail
{
    //Representation of the trail; the total number of markers is markers.length
    private int[] markers;
    
    /**
     * Makes markers accessable
     * @param markers   the original array of heights
     */
    public Trail(int[] markers) {
        this.markers = markers;
    }
    
    /**
     * Determines if a trail segment is level. A trail segment is define by 
     * a starting marker, an ending marker, and all markers between those two
     * markers. 
     * A trail segment is level if it has a difference between the maximum elevation 
     * and minimum elevation that is less than or equal to 10 meters.
     * 
     * @param start  the index of the starting marker
     * @param end    the index of the ending marker
     *                Precondition: 0 <= start < end <= markers.length - 1
     * 
     * @return true  if the different between the maximum and minimum elevation
     *               on this segment of the trail is less than or equal to 10 
     *               meters;
     *         false otherwise
     */
    public boolean isLevelTrailSegment(int start, int end)
    {
        int max = markers[start];
        int min = markers[start];
        for (int i = start; i <= end; i++) {
            if (markers[i] > max) {
                max = markers[i];
            }
            
            if (markers[i] < min) {
                min = markers[i];
            }
        }
        
        return (max-min <= 10);
    }

    /**
     * Determines if this trail is rated difficult. A trail is rated by counting 
     * the number of changes in elevation that are at least 30 meters (up or down)
     * between two consecutive markers. A trail with 3 or more of such changes is 
     * rated difficult.
     * 
     * @return true   if the trail is rated difficult
     *         false  otherwise
     */
    public boolean isDifficult()
    {
        int count = 0;
        for (int i = 1; i < markers.length; i++) {
            if (Math.abs(markers[i] - markers[i-1]) >= 30){
                count++;
            }
        }
        return (count >= 3);
    }
}
