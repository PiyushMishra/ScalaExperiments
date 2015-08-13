object Functors {

  def listToXml(list: List[Contact]): List[XMLContact] = {
    list match {
      case Nil => Nil
      case x :: xs => XMLContact(x.name, x.email) :: listToXml(xs)
    }
  }                                               //> listToXml: (list: List[com.practice.Contact])List[com.practice.XMLContact]

  def listTojson(list: List[Contact]): List[JSONContact] = {
    list match {
      case Nil => Nil
      case x :: xs => JSONContact(x.name, x.email) :: listTojson(xs)
    }
  }                                               //> listTojson: (list: List[com.practice.Contact])List[com.practice.JSONContact]
                                                  //| 

  def listMap[A, B](transformor: A => B)(list: List[A]): List[B] = {
    list match {
      case Nil => Nil
      case x :: xs => transformor(x) :: listMap(transformor)(xs)
    }
  }                                               //> listMap: [A, B](transformor: A => B)(list: List[A])List[B]

  val toXml = (contact: Contact) => XMLContact(contact.name, contact.email)
                                                  //> toXml  : com.practice.Contact => com.practice.XMLContact = <function1>
  val toJson = (contact: Contact) => JSONContact(contact.name, contact.email)
                                                  //> toJson  : com.practice.Contact => com.practice.JSONContact = <function1>

  val contactsToXmlConvertor = listMap(toXml) _   //> contactsToXmlConvertor  : List[com.practice.Contact] => List[com.practice.XM
                                                  //| LContact] = <function1>
  val contactsToJsonConvertor = listMap(toJson) _ //> contactsToJsonConvertor  : List[com.practice.Contact] => List[com.practice.J
                                                  //| SONContact] = <function1>
  val paul = Contact("Paul", "paul@mail.com")     //> paul  : com.practice.Contact = Contact(Paul,paul@mail.com)
  val peter = Contact("Peter", "peter@mail.com")  //> peter  : com.practice.Contact = Contact(Peter,peter@mail.com)
  contactsToJsonConvertor(List(paul, peter))      //> res0: List[com.practice.JSONContact] = List(JSONContact(Paul,paul@mail.com),
                                                  //|  JSONContact(Peter,peter@mail.com))

  def optionMap[A, B](transformor: A => B)(option: Option[A]): Option[B] = {
    option match {
      case Some(value) => Some(transformor(value))
      case None => None
    }
  }                                               //> optionMap: [A, B](transformor: A => B)(option: Option[A])Option[B]

  val optionXml = optionMap(toXml) _              //> optionXml  : Option[com.practice.Contact] => Option[com.practice.XMLContact
                                                  //| ] = <function1>

  optionXml(Some(peter))                          //> res1: Option[com.practice.XMLContact] = Some(XMLContact(Peter,peter@mail.co
                                                  //| m))

  trait Functor[M[_]] {
    def fmap[A, B](transformor: A => B): M[A] => M[B]
  }

 implicit val listFunctor = new Functor[List] {
    def fmap[A, B](transformor: A => B): List[A] => List[B] = {
      _ match {
        case Nil => Nil
        case x :: xs => transformor(x) :: fmap(transformor)(xs)
      }
    }
  }                                               //> listFunctor  : com.practice.Functors.Functor[List] = com.practice.Functors$
                                                  //| $anonfun$main$1$$anon$1@79b4d0f

 implicit val optionFunctor = new Functor[Option] {
    def fmap[A, B](transformor: A => B): Option[A] => Option[B] = {
      _ match {
        case None => None
        case Some(value) => Some(transformor(value))
      }
    }
  }                                               //> optionFunctor  : com.practice.Functors.Functor[Option] = com.practice.Funct
                                                  //| ors$$anonfun$main$1$$anon$2@6b2fad11

implicit def enrichWithFunctor[A, M[_]](m:M[A]) = new {
  def mapWith[B](transformor: A => B)(implicit functor: Functor[M]):M[B] = functor.fmap(transformor)(m)

}                                                 //> enrichWithFunctor: [A, M[_]](m: M[A])AnyRef{def mapWith[B](transformor: A =
                                                  //| > B)(implicit functor: com.practice.Functors.Functor[M]): M[B]}
     List(paul).mapWith(a => a.name + a.email)    //> res2: List[String] = List(Paulpaul@mail.com)
}

trait PersistanceAPI {

  def byId(id: Long): Option[Contact]
  def all: List[Contact]

}

case class Contact(name: String, email: String)
case class XMLContact(name: String, email: String)
case class JSONContact(name: String, email: String)
