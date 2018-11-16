package a6test.amlahey;

import static org.junit.Assert.*;

import org.junit.Test;

import a6*;

public class A6Tests {

	@Test
	public void testRegionImplConstructor() {
			
		try {
			RegionImpl invalidWidthRegion = new RegionImpl(3, 1, 2, 5);
			fail("invalid dimensions");	
		}catch (IllegalArgumentException e) {
			
		}
		
		try {
			RegionImpl invalidHeightRegion = new RegionImpl(3, 4, 8, 2);
			fail("invalid dimensions");	
		}catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void testRegionImplGetters() {
		RegionImpl testRegion = new RegionImpl(2, 4, 9, 7);
		assertEquals(testRegion.getLeft(), 2);
		assertEquals(testRegion.getTop(), 4 );
		assertEquals(testRegion.getRight(), 9 );
		assertEquals(testRegion.getBottom(), 7 );
	}
	
	@Test
	public void testRegionIntersectNoIntersect() {
		RegionImpl testRegion = new RegionImpl(4, 4, 8, 7);
		try {
			RegionImpl nullRegion = null;
			testRegion.intersect(nullRegion);
			fail("other region is null");
		}catch (NoIntersectionException e) {
			
		}
		try {
			RegionImpl otherRegion = new RegionImpl(9, 12, 10, 14);
			testRegion.intersect(otherRegion);
			fail("no intersection");
		}catch (NoIntersectionException e) {
			
		}
		try {
			RegionImpl otherRegion = new RegionImpl(1, 9, 3, 15);
			testRegion.intersect(otherRegion);
			fail("no intersection");
		}catch (NoIntersectionException e) {
			
		}
		
	}
	
	@Test
	public void testRegionIntersect() {
		RegionImpl testRegion = new RegionImpl(2, 4, 9, 7);
		RegionImpl rightOtherRegion = new RegionImpl(6, 5, 10, 6);
		RegionImpl leftOtherRegion = new RegionImpl(1, 2, 7, 7);		
		
		try {
			assertEquals(testRegion.intersect(rightOtherRegion).getLeft(), 6);
			assertEquals(testRegion.intersect(rightOtherRegion).getTop(), 5);
			assertEquals(testRegion.intersect(rightOtherRegion).getRight(), 9);
			assertEquals(testRegion.intersect(rightOtherRegion).getBottom(), 6);
		} catch (NoIntersectionException e) {
			fail("There is an intersection");
		}
		
		try {
			assertEquals(testRegion.intersect(leftOtherRegion).getLeft(), 2);
			assertEquals(testRegion.intersect(leftOtherRegion).getTop(), 4);
			assertEquals(testRegion.intersect(leftOtherRegion).getRight(), 7);
			assertEquals(testRegion.intersect(leftOtherRegion).getBottom(), 7);
		} catch (NoIntersectionException e) {
			fail("There is an intersection");
		}
		
	}
	@Test
	public void testRegionUnion() {
		RegionImpl nullRegion = null;
		RegionImpl testRegion = new RegionImpl(2, 4, 9, 7);
		RegionImpl rightOtherRegion = new RegionImpl(6, 5, 10, 6);
		RegionImpl leftOtherRegion = new RegionImpl(1, 2, 7, 7);
		RegionImpl rightUnionRegion = new RegionImpl(6, 5, 9, 6);
		RegionImpl leftUnionRegion = new RegionImpl(1, 2, 7, 7);
		
		
		assertEquals(testRegion.union(nullRegion), testRegion);
		
		
			assertEquals(testRegion.union(rightOtherRegion).getLeft(), 2);
			assertEquals(testRegion.union(rightOtherRegion).getTop(), 4);
			assertEquals(testRegion.union(rightOtherRegion).getRight(), 10);
			assertEquals(testRegion.union(rightOtherRegion).getBottom(), 7);
		
			assertEquals(testRegion.union(leftOtherRegion).getLeft(), 1);
			assertEquals(testRegion.union(leftOtherRegion).getTop(), 2);
			assertEquals(testRegion.union(leftOtherRegion).getRight(), 9);
			assertEquals(testRegion.union(leftOtherRegion).getBottom(), 7);
			
		
	}

}
