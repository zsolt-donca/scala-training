
// linked list

val list: List[String] = "one" :: "two" :: "three" :: "four" :: "five" :: Nil

list.head
list.tail

// decomposition

val (h :: t) = list

def concatenate(list: List[String]): String = {
  list match {
    case head :: tail => head + " " + concatenate(tail)
    case Nil => ""
  }
}

concatenate(list)

// TODO Find the ultimate element of the list.
// TODO Find the penultimate element of the list

// TODO make it comma-separated
// TODO drop the last comma (to make it "one, two, three, four, five)"


// http://aperiodic.net/phil/scala/s-99/

