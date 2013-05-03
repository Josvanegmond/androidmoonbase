package spaceappschallenge.moonville.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BuildingTreeIterator<T> implements Iterator<Building>
{
	private Stack<BuildingTree> buildingTreeStack;
	private List<Building> iterableBuildingList;
	
	public BuildingTreeIterator( BuildingTree root )
	{
		this.buildingTreeStack = new Stack<BuildingTree>();
		this.buildingTreeStack.push( root );
		
		this.iterableBuildingList = new ArrayList<Building>();
	}
	
	
	@Override
	public boolean hasNext()
	{
		return buildingTreeStack.size() > 0;
	}

	@Override
	public Building next()
	{
		//pop the current buildingtree off the stack
		BuildingTree buildingTreeNode = buildingTreeStack.pop();
		
		//add all children of buildingtree to the stack
		for( BuildingTree buildingTreeChild : buildingTreeNode.getChilds() )
		{
			buildingTreeStack.push( buildingTreeChild );
		}
		
		//get and return the building object associated with the buildingtree node
		Building building = buildingTreeNode.getBuilding();
		return building;
	}

	@Override
	public void remove()
	{
		throw new UnsupportedOperationException( "Can not remove childs from buildingtree during iteration" );
	}

}
