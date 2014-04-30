package domains;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.NodeEntity;


/**
 * Created by jesse on 4/29/2014.
 */
@NodeEntity
@TypeAlias("AdventuringClass")
public class AdventuringClass extends AbstractBaseClass {


    private ClassType.ADVENTURING class_type = ClassType.ADVENTURING.DISCIPLES_OF_WAR;

    public AdventuringClass (String name, ClassType.ADVENTURING class_type ) {
        super(name);

        this.class_type = class_type;
    }

    public AdventuringClass addAdvanceClass(AdventuringClass adventuringClass) {

    }

    @Override
    public boolean equals() {
        return false;
    }
}
