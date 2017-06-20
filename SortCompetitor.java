/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author tony.tian
 */
public interface SortCompetitor {
    public String getOwner();
	public void sortn2(Comparable[] data);  
	public void sortn2Alt(Comparable[] data);
	public void sortnlgn(Comparable[] data);
	public void sortnlgnAlt(Comparable[] data);
	public void wildcard(Integer[] data);
}
