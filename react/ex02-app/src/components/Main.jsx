import Aside from "./Aside";
import Section from "./Section";

export default function Main() {
  return (
    <div className="flex flex-row">
      <Aside />
      <Section />
    </div>
  );
}
