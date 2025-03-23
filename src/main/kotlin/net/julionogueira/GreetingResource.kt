package net.julionogueira

import jakarta.json.Json
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import net.julionogueira.leetcode.ArrayStringSection

import net.julionogueira.ztm.sectionthree.*
import kotlin.random.Random

@Path("/hello")
class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello from Quarkus REST"

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    fun callTest(): String {
        val test = TestClass()
        return test.runTest()
    }
}

@Path("/exercises")
class ExercisesResource {
    @GET
    @Path("/ztm/find-nemo/")
    @Produces(MediaType.TEXT_PLAIN)
    fun findNemo(): String {
        val exercises = Exercises()
        //val myList = listOf("dory","daddy","nem")
        // 100 characters of child movies
        val myList = listOf(
            "Mickey Mouse", "Minnie Mouse", "Donald Duck", "Goofy", "Daisy Duck", "Pluto",
            "SpongeBob SquarePants", "Patrick Star", "Squidward Tentacles", "Mr. Krabs",
            "Sandy Cheeks", "Plankton", "Gary", "Simba", "Mufasa", "Scar", "Timon", "Pumbaa",
            "Ariel", "Flounder", "Sebastian", "King Triton", "Ursula", "Eric",
            "Peter Pan", "Wendy", "Tinker Bell", "Captain Hook", "Mr. Smee",
            "Cinderella", "Fairy Godmother", "Prince Charming", "Lady Tremaine",
            "Aurora", "Prince Phillip", "Maleficent", "Flora", "Fauna", "Merryweather",
            "Belle", "Beast", "Gaston", "Lumière", "Cogsworth", "Mrs. Potts", "Chip",
            "Snow White", "The Evil Queen", "The Seven Dwarfs", "Aladdin", "Jasmine",
            "Genie", "Jafar", "Abu", "Iago", "Raja", "Elsa", "Anna", "Olaf", "Kristoff",
            "Sven", "Hercules", "Megara", "Hades", "Phil", "Mulan", "Mushu",
            "Li Shang", "Pocahontas", "John Smith", "Meeko", "Flit",
            "Rapunzel", "Flynn Rider", "Pascal", "Maximus",
            "Merida", "Queen Elinor", "King Fergus", "The Triplets",
            "Winnie the Pooh", "Piglet", "Tigger", "Eeyore", "Kanga", "Roo", "Owl", "Rabbit",
            "Tarzan", "Jane", "Professor Porter", "Kala", "Kerchak",
            "Robin Hood", "Little John", "Maid Marian", "Prince John", "Sir Hiss",
            "Pinocchio", "Jiminy Cricket", "Geppetto", "Figaro", "The Blue Fairy"
        )
        return exercises.findNemo(myList)
    }


    @GET
    @Path("/ztm/find-int-sequential/")
    @Produces(MediaType.TEXT_PLAIN)
    fun findInt(): String {
        val exercises = Exercises()
        val rdm = Random
        val myList = (1..100000000).map { rdm.nextInt() }
        return exercises.findInt(myList, Exercises.findMethod.SEQUENTIAL)
    }

    @GET
    @Path("/leetcode/remove-duplicates")
    @Produces(MediaType.APPLICATION_JSON)
    fun removeDuplicates(): String{
        val nums = intArrayOf(0,0,1,1,1,2,2,3,3,4)
        val exercises = ArrayStringSection()
        val finalSize = exercises.removeDuplicatesV2(nums)

        // Create JSON response using Jakarta JSON API
        val jsonObject = Json.createObjectBuilder()
            .add("finalSize", finalSize)
            .add("modifiedArray", nums.sliceArray(nums.indices).joinToString(", ", "[", "]"))
            .build()


        return jsonObject.toString()
    }


    @GET
    @Path("/leetcode/merge-sorted")
    @Produces(MediaType.APPLICATION_JSON)
    fun mergeSorted(): String{
        // Test case 1
        /*
        val nums1: IntArray = intArrayOf(1,2,3,0,0,0)
        val m = 3
        val nums2: IntArray = intArrayOf(2,5,6)
        val n = 3
        */

        // Test case 2

        /*var nums1: IntArray = intArrayOf(1)
        val m = 1
        val nums2: IntArray = intArrayOf()
        val n = 0*/

        // Test case 3
        /*
        val nums1: IntArray = intArrayOf(0)
        val m = 0
        val nums2: IntArray = intArrayOf(1)
        val n = 1
        */

        // Test case 4
        /*
        val nums1: IntArray = intArrayOf(2,0)
        val m = 1
        val nums2: IntArray = intArrayOf(1)
        val n = 1
        */

        // Test case 5

        val nums1: IntArray = intArrayOf(0,0,3,0,0,0,0,0,0)
        val m = 3
        val nums2: IntArray = intArrayOf(-1,1,1,1,2,3)
        val n = 6



        val exercises = ArrayStringSection()

        exercises.mergeSorted(nums1, m, nums2, n)

        // Create JSON response using Jakarta JSON API
        val jsonObject = Json.createObjectBuilder()
            .add("nums1", nums1.sliceArray(nums1.indices).joinToString(", ", "[", "]"))
            .build()


        return jsonObject.toString()
    }
}