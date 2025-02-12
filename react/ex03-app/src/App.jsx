import SiteHeader from "./components/SiteHeader.jsx";
import MainContent from "./components/MainContent.jsx";

export default function App() {
  return (
    <div className="m-0 p-0">
      <div className="mx-auto h-full">
        <SiteHeader />
        <MainContent />
      </div>
    </div>
  );
}
