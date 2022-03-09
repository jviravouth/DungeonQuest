/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hasttest;

public class GraphObj 
{
    public String objName;
    public GraphObj[] objLinks;
    
    GraphObj(String name)
    {
        objName = name;
    }
    
    public void createLinks(GraphObj[] links)
    {
        objLinks = links;
    }
}
